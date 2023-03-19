package colman.android.streetcourts.feed.PostList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import colman.android.streetcourts.R;
import colman.android.streetcourts.feed.PostList.PostListRvFragmentDirections;

import colman.android.streetcourts.model.Model;
import colman.android.streetcourts.model.Post;
import com.squareup.picasso.Picasso;


public class PostListRvFragment extends Fragment {

    public PostListRvFragment() {
        // Required empty public constructor
    }

    //MEMBERS
    PostListViewModel viewModel;
    RecyclerView listRv;
    MyAdapter adapter;
    SwipeRefreshLayout swipeRefresh;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(this).get(PostListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list_rv, container, false);

        //setting the recycler view
        swipeRefresh = view.findViewById(R.id.postlist_swiperefresh);
        swipeRefresh.setOnRefreshListener(() -> {
            Model.instance.refreshPostsList();
        });

        listRv = view.findViewById(R.id.postlist_rv);
        listRv.setHasFixedSize(true);
        listRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyAdapter();
        listRv.setAdapter(adapter);

        //setting the adapter listeners
        adapter.setOnItemClickListener((v, position) -> {
            String postId = viewModel.getData().getValue().get(position).getId();
            String postUId = viewModel.getData().getValue().get(position).getUserId();
            Navigation.findNavController(v).navigate(PostListRvFragmentDirections.actionGlobalPostFragment(postId, postUId));
        });
        viewModel.getData().observe(getViewLifecycleOwner(), list -> refresh());

        swipeRefresh.setRefreshing(Model.instance.getPostsListLoadingState().getValue() == Model.PostsListLoadingState.loading);
        Model.instance.getPostsListLoadingState().observe(getViewLifecycleOwner(), postsListLoadingState -> {
            swipeRefresh.setRefreshing(Model.instance.getPostsListLoadingState().getValue() == Model.PostsListLoadingState.loading);
        });
        Model.instance.refreshPostsList();
        return view;
    }

    private void refresh() {
        adapter.notifyDataSetChanged();
    }


    //HOLDER CLASS
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView categoryTv;
        TextView areaTv;
        ImageView image;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.postrow_name_tv);
            categoryTv = itemView.findViewById(R.id.postrow_category_tv);
            image = itemView.findViewById(R.id.postrow_image_imv);
            areaTv = itemView.findViewById(R.id.postrow_area_tv);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                listener.onItemClick(itemView, pos);
            });
        }

        public void bind(Post post) {
            if (post != null) {
                nameTv.setText(post.getName());
                categoryTv.setText(post.getCategory());
                areaTv.setText(post.getAddress());
                image.setImageResource(R.drawable.avatarsmith);
                if (post.getImage() != null) {
                    Picasso.get()
                            .load(post.getImage())
                            .into(image);
                }
            }
        }
    }

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    //ADAPTER CLASS
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        OnItemClickListener listener;

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.post_list_row, parent, false);
            MyViewHolder holder = new MyViewHolder(view, listener);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Post post = viewModel.getData().getValue().get(position);
            holder.bind(post);
        }

        @Override
        public int getItemCount() {
            if (viewModel.getData().getValue() == null) {
                return 0;
            }
            return viewModel.getData().getValue().size();
        }
    }
}