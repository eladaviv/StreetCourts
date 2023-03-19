package colman.android.streetcourts.feed.MemberList;

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
import colman.android.streetcourts.feed.MemberList.MemberListRvFragmentDirections;

import colman.android.streetcourts.model.Member;
import colman.android.streetcourts.model.MemberViewModel;
import colman.android.streetcourts.model.Model;
import com.squareup.picasso.Picasso;


public class MemberListRvFragment extends Fragment {

    //MEMBERS
    MemberListRvViewModel viewModel;
    RecyclerView listRv;
    MyAdapter adapter;
    SwipeRefreshLayout swipeRefresh;
    MemberViewModel memberViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(this).get(MemberListRvViewModel.class);
        memberViewModel = new ViewModelProvider(this).get(MemberViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member_list, container, false);

        swipeRefresh = view.findViewById(R.id.memberlist_swiperefresh);
        swipeRefresh.setOnRefreshListener(() -> {
            Model.instance.refreshMembersList();
        });
        listRv = view.findViewById(R.id.memberlist_rv);
        listRv.setHasFixedSize(true);
        listRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyAdapter();
        listRv.setAdapter(adapter);


        adapter.setOnItemClickListener((v, position) -> {
            String memberId = viewModel.getData().getValue().get(position).getId();
            Navigation.findNavController(v).navigate(MemberListRvFragmentDirections.actionMemberListRvFragmentToMemberDetailsFragment(memberId, Model.instance.getUid()));
        });
        viewModel.getData().observe(getViewLifecycleOwner(), list -> refresh());

        swipeRefresh.setRefreshing(Model.instance.getMembersListLoadingState().getValue() == Model.MembersListLoadingState.loading);
        Model.instance.getMembersListLoadingState().observe(getViewLifecycleOwner(), membersListLoadingState -> {
            swipeRefresh.setRefreshing(Model.instance.getMembersListLoadingState().getValue() == Model.MembersListLoadingState.loading);
        });
        return view;
    }

    private void refresh() {
        adapter.notifyDataSetChanged();
    }


    //HOLDER CLASS
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView idTv;
        ImageView avatar;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.listrow_name_tv);
            idTv = itemView.findViewById(R.id.listrow_id_tv);
            avatar = itemView.findViewById(R.id.listrow_avatar_imv);
            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                listener.onItemClick(itemView, pos);
            });
        }

        public void bind(Member member) {
            if (member != null) {
                nameTv.setText(member.getName());
                idTv.setText(member.getId());
                avatar.setImageResource(R.drawable.avatarsmith);
                if (member.getAvatar() != null) {
                    Picasso.get()
                            .load(member.getAvatar())
                            .into(avatar);
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
            View view = getLayoutInflater().inflate(R.layout.member_list_row, parent, false);
            MyViewHolder holder = new MyViewHolder(view, listener);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Member member = viewModel.getData().getValue().get(position);
            holder.bind(member);
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