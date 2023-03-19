package colman.android.streetcourts.feed.AddPost;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import colman.android.streetcourts.model.Category;
import colman.android.streetcourts.model.Model;

import java.util.List;

public class AddPostViewModel extends ViewModel {
    LiveData<List<Category>> data;

    public AddPostViewModel() {
        data = Model.instance.getAllCategories();
    }

    public LiveData<List<Category>> getData() {
        return data;
    }

}
