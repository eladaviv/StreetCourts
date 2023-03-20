package colman.android.streetcourts.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import colman.android.streetcourts.R;
import colman.android.streetcourts.feed.AddCategoryFragmentDirections;

import colman.android.streetcourts.model.Category;
import colman.android.streetcourts.model.Model;


public class AddCategoryFragment extends Fragment {


    public AddCategoryFragment() {
        // Required empty public constructor

    }

    public static AddCategoryFragment newInstance() {
        AddCategoryFragment fragment = new AddCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void save() {
        progressBar.setVisibility(View.VISIBLE);
        saveBtn.setEnabled(false);
        cancelBtn.setEnabled(false);
        progressBar.setVisibility(View.GONE);

        String snameTv = nameTv.getText().toString();

        Category category = new Category(snameTv);
        Model.instance.addCategory(category, () -> Navigation.findNavController(nameTv).navigate(AddCategoryFragmentDirections.actionGlobalPostListRvFragment()));
    }

    EditText nameTv;
    Button cancelBtn;
    Button saveBtn;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_category, container, false);

        progressBar = view.findViewById(R.id.add_category_progressbar);
        progressBar.setVisibility(View.GONE);
        nameTv = view.findViewById(R.id.add_category_name_txt);
        cancelBtn = view.findViewById(R.id.add_category_cancel_btn);
        saveBtn = view.findViewById(R.id.add_category_save_btn);

        cancelBtn.setOnClickListener(v -> {
            Navigation.findNavController(v).navigateUp();
        });
        saveBtn.setOnClickListener(v -> {
            save();
        });

        return view;
    }
}