package colman.android.streetcourts.feed.EditPost;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import colman.android.streetcourts.model.Category;
import colman.android.streetcourts.model.Model;
import colman.android.streetcourts.model.Post;

import java.util.List;

public class EditPostViewModel extends ViewModel {
    LiveData<Post> data;
    LiveData<List<Category>> categories;

    public EditPostViewModel() {
        data = new MutableLiveData<Post>();
        categories = Model.instance.getAllCategories();
    }

    public LiveData<Post> getData(String id) {
        data = Model.instance.getPostById(id);
        return data;
    }

    public LiveData<List<Category>> getCategories() {
        return categories;
    }
}
