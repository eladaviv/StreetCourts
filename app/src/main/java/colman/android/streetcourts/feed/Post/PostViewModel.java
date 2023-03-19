package colman.android.streetcourts.feed.Post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import colman.android.streetcourts.model.Model;
import colman.android.streetcourts.model.Post;

public class PostViewModel extends ViewModel {
    LiveData<Post> data;

    public PostViewModel() {
        data = new MutableLiveData<>();
    }

    public LiveData<Post> getData(String id) {
        data = Model.instance.getPostById(id);
        return data;
    }
}
