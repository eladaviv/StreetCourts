package colman.android.streetcourts.feed.LocationsMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import colman.android.streetcourts.MyApplication;
import colman.android.streetcourts.R;
import colman.android.streetcourts.feed.PostList.PostListRvFragmentDirections;
import colman.android.streetcourts.feed.PostList.PostListViewModel;
import colman.android.streetcourts.model.Model;
import colman.android.streetcourts.model.Post;
import colman.android.streetcourts.services.TemperatureApiService;

public class LocationsMapFragment extends Fragment {

    PostListViewModel viewModel;
    LiveData<List<Post>> posts;
    TextView temp;
    String postTemperature = "25f°C";
    View thisView; // for the navigation
    private class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

        private Context context;
        public CustomInfoWindowAdapter(Context context) {
            this.context = context;
        }

        @Nullable
        @Override
        public View getInfoContents(@NonNull Marker marker) {

            return null;
        }

        @Nullable
        @Override
        public View getInfoWindow(@NonNull Marker marker) {
            View view = LayoutInflater.from(this.context).inflate(R.layout.location_info_win_layout, null);
            Post post = (Post) marker.getTag();
            ImageView img = view.findViewById(R.id.location_image);
            temp = view.findViewById(R.id.location_temp);

            if (post.getImage() != null) {
                Picasso.get()
                        .load(post.getImage())
                        .into(img);
                Geocoder geco = new Geocoder(this.context);
                try {
                        this.getTemperatureByCoordinates(post.getGeoPoint().getLatitude(), post.getGeoPoint().getLongitude());
                        temp.setText(postTemperature);

                    List<Address> addresses = geco.getFromLocation(marker.getPosition().latitude, marker.getPosition().longitude, 5);
                    Toast.makeText(this.context, addresses.get(0).getAddressLine(0).toString(), Toast.LENGTH_SHORT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            TextView tv_name = view.findViewById(R.id.tv_location_name);
            Button btn_test = view.findViewById(R.id.location_btn);
            tv_name.setText(post.getName());
            btn_test.setText(post.getArea());
            return view;
        }


        public void getTemperatureByCoordinates(double latitude, double longitude) {
            new AsyncTask<Void, Void, Double>() {
                @Override
                protected Double doInBackground(Void... voids) {
                    try {
                        double x = TemperatureApiService.getTemperature(latitude,longitude);
                        return x;
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(Double temperature) {
//                    temp.setText("hvmhb");
                    postTemperature = String.format("%.1f°C", temperature);
//                    return temperature;
//                    temp.setText(String.format("%.1f°C", temperature));
                }
            }.execute();
        }
    }
    protected CustomInfoWindowAdapter infoWindowAdapter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        infoWindowAdapter = new CustomInfoWindowAdapter(context);
        viewModel = new ViewModelProvider(this).get(PostListViewModel.class);
        posts = viewModel.getData();
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Tel Aviv, Israel.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            Toast.makeText(MyApplication.getContext(), "Map is ready", Toast.LENGTH_SHORT);
            LatLng TelAviv = new LatLng(32.085300, 34.781769);
            googleMap.setInfoWindowAdapter(infoWindowAdapter);
            viewModel.getData().observe(getViewLifecycleOwner(), posts -> {
                for (Post p : posts) {
                    Marker marker = googleMap.addMarker(new MarkerOptions().position(new LatLng(p.getGeoPoint().getLatitude(), p.getGeoPoint().getLongitude())));
                    marker.setTag(p);
//
                }
            });


            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(@NonNull Marker marker) {
                    if(!marker.isInfoWindowShown()) {
                        Post p = (Post) marker.getTag();
                        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                        marker.showInfoWindow();
                    }
                    else{
                        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                        marker.hideInfoWindow();
                    }
                    return true;
                }
            });
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(TelAviv,12));
            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(@NonNull Marker marker) {
                    Post post = (Post) marker.getTag();
                    String postId = post.getId();
                    String userId = post.getUserId();
                    Navigation.findNavController(thisView).navigate(PostListRvFragmentDirections.actionGlobalPostFragment(postId, userId));
                }
            });
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_locations_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        thisView = view; // for the navigation
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}