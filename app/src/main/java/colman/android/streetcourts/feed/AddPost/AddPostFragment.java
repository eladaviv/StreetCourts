package colman.android.streetcourts.feed.AddPost;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.firebase.firestore.GeoPoint;

import colman.android.streetcourts.MyApplication;
import colman.android.streetcourts.R;
import colman.android.streetcourts.model.Category;
import colman.android.streetcourts.model.Model;
import colman.android.streetcourts.model.Post;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPostFragment extends Fragment {
    String address_line;
    LocationManager locationManager;
    Location loc;
    Geocoder geco;
    public AddPostFragment() {
        // Required empty public constructor
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location)
        {
            loc = location;
            try {
                List<Address> addresses = geco.getFromLocation(location.getLatitude(), location.getLongitude(), 5);
                address_line = addresses.get(0).getAddressLine(0).toString();
                addressTv.setText(address_line);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}

        @Override
        public void onProviderEnabled(String provider) {}

        @Override
        public void onProviderDisabled(String provider) {}
    };

    public static AddPostFragment newInstance() {
        AddPostFragment fragment = new AddPostFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @SuppressLint("MissingPermission")
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(this).get(AddPostViewModel.class);
        geco = new Geocoder(context);

        // Get the location manager
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        // Request location updates
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastKnownLocation != null) {
                // Do something with the last known location
                double latitude=0;
                double longitude=0;
                latitude = lastKnownLocation.getLatitude();
                longitude = lastKnownLocation.getLongitude();
                Log.d("locations", "latitude = "+latitude + "longitude = "+longitude);
                try {
                    List<Address> addresses = geco.getFromLocation(latitude, longitude, 5);
                    Log.d("locations", "addresses = "+addresses.get(0).getAddressLine(0).toString());
                    address_line = addresses.get(0).getAddressLine(0).toString();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            } else {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


//

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void save() throws IOException{
        progressBar.setVisibility(View.VISIBLE);
//        saveBtn.setEnabled(false);
//        cancelBtn.setEnabled(false);
        progressBar.setVisibility(View.GONE);
        boolean valid_address = false;
        boolean valid_details = false;

        String snameTv = nameTv.getText().toString();
        String scategoryTv = categoryTv.getText().toString();
        String sareaTv = areaTv.getText().toString();
        String saddressTv = addressTv.getText().toString();
        String sdescriptionTv = descriptionTv.getText().toString();

        GeoPoint geopoint = new GeoPoint(32.085300, 34.781769);
        List<Address> PostAddress = null;
        if(!saddressTv.isEmpty()){
            PostAddress = geco.getFromLocationName(saddressTv, 1);
        }
        if (PostAddress != null && !PostAddress.isEmpty()) {
            Address address = PostAddress.get(0);
            geopoint = new GeoPoint(address.getLatitude(), address.getLongitude());
            valid_address = true;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Invalid Address");
            builder.setMessage("Please fill in a correct address");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do something when the "OK" button is clicked
                    cancelBtn.setEnabled(true);
                    cancelBtn.setClickable(true);
                    saveBtn.setEnabled(true);
                    saveBtn.setClickable(true);
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do something when the "Cancel" button is clicked
                    cancelBtn.setEnabled(true);
                    cancelBtn.setClickable(true);
                    saveBtn.setEnabled(true);
                    saveBtn.setClickable(true);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }

        if(!snameTv.isEmpty() && !scategoryTv.isEmpty() && !sareaTv.isEmpty()
        && !saddressTv.isEmpty() && !sdescriptionTv.isEmpty())
        {
            valid_details = true;
        }
        else
        {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
            builder2.setTitle("Invalid Details");
            builder2.setMessage("Please fill in all the fields");

            builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do something when the "OK" button is clicked
                    cancelBtn.setEnabled(true);
                    cancelBtn.setClickable(true);
                    saveBtn.setEnabled(true);
                    saveBtn.setClickable(true);
                }
            });

            builder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do something when the "Cancel" button is clicked
                    cancelBtn.setEnabled(true);
                    cancelBtn.setClickable(true);
                    saveBtn.setEnabled(true);
                    saveBtn.setClickable(true);
                }
            });

            AlertDialog dialog = builder2.create();
            dialog.show();
        }

        if(valid_address && valid_details)
        {
            Post post = new Post(snameTv, UUID.randomUUID().toString(), scategoryTv, saddressTv, null, sareaTv, Model.instance.getUid(), sdescriptionTv, geopoint);
            Bitmap defaultImageBitmap = imageBitmap;
            if(imageBitmap == null){
                defaultImageBitmap = this.saveDefaultImageByCategory(post.getCategory());
            }
            Model.instance.saveImage(defaultImageBitmap, "P" + post.getId() + "U" + post.getUserId() + ".jpg", url -> {
                post.setImage(url);
                Model.instance.addPost(post, () -> {
                    Navigation.findNavController(nameTv).navigateUp();
                });
            });
        }
    }

    public Bitmap saveDefaultImageByCategory(String category){
        switch (category){
            case "Tennis":
                return ((BitmapDrawable) getResources().getDrawable(R.drawable.tennis_court)).getBitmap();
            case "Basketball":
                return ((BitmapDrawable) getResources().getDrawable(R.drawable.basketball_court)).getBitmap();
            case "Football":
                return ((BitmapDrawable) getResources().getDrawable(R.drawable.football_court)).getBitmap();
            default:
                return ((BitmapDrawable) getResources().getDrawable(R.drawable.avatarsmith)).getBitmap();

        }
    }

    ArrayAdapter<String> adapter;
    AddPostViewModel viewModel;
    List<String> categories;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_GALLERY_OPEN = 2;
    Bitmap imageBitmap;
    EditText nameTv;
    AutoCompleteTextView categoryTv;
    EditText areaTv;
    EditText addressTv;
    EditText descriptionTv;
    Button cancelBtn;
    Button saveBtn;
    ImageView image;
    ImageButton cameraBtn;
    ImageButton galleryBtn;
    ProgressBar progressBar;

    @SuppressLint("MissingPermission")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_post, container, false);
       // locationManager.removeUpdates(locationListener);

        progressBar = view.findViewById(R.id.add_post_progressbar);
        progressBar.setVisibility(View.GONE);
        nameTv = view.findViewById(R.id.add_post_name_txt);
        categoryTv = view.findViewById(R.id.add_post_category_txt);
        areaTv = view.findViewById(R.id.add_post_area_txt);
        addressTv = view.findViewById(R.id.add_post_address_txt);
        descriptionTv = view.findViewById(R.id.add_post_description_txt);
        image = view.findViewById(R.id.add_post_imgv);
        cancelBtn = view.findViewById(R.id.add_post_cancel_btn);
        saveBtn = view.findViewById(R.id.add_post_save_btn);
        cameraBtn = view.findViewById(R.id.add_post_camera_btn);
        galleryBtn = view.findViewById(R.id.add_post_gallery_btn);

        cancelBtn.setOnClickListener(v -> {
            Navigation.findNavController(v).navigateUp();
        });
        saveBtn.setOnClickListener(v -> {
            try {
                save();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Failed to save post", Toast.LENGTH_LONG).show();
            }
        });
        cameraBtn.setOnClickListener(v -> {
            openCamera();
        });
        galleryBtn.setOnClickListener(v -> {
            openGallery();
        });

        addressTv.setText(address_line);

        categories = new ArrayList<>();
        List<Category> cat = new ArrayList<Category>();
        cat = viewModel.getData().getValue();

        if (cat != null) {
            for (Category category : cat) {
                categories.add(category.getName());
            }
        }

        adapter = new ArrayAdapter<String>(requireContext(), R.layout.category_list_item, categories);
        categoryTv.setAdapter(adapter);


        viewModel.getData().observe(getViewLifecycleOwner(), categoryList -> {
            categories.removeAll(categories);
            for (Category category : categoryList) {
                categories.add(category.getName());
            }
            adapter = new ArrayAdapter<String>(requireContext(), R.layout.category_list_item, categories);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    private void openGallery() {
        Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
        openGalleryIntent.setType("image/*");
        startActivityForResult(openGalleryIntent, REQUEST_GALLERY_OPEN);
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                imageBitmap = (Bitmap) extras.get("data");
                image.setImageBitmap(imageBitmap);
            }
        } else if (requestCode == REQUEST_GALLERY_OPEN) {
            if (resultCode == RESULT_OK) {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContext().getContentResolver().openInputStream(imageUri);
                    imageBitmap = BitmapFactory.decodeStream(imageStream);
                    image.setImageBitmap(imageBitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Failed to select image from gallery", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
