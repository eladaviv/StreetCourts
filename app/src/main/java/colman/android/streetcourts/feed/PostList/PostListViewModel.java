package colman.android.streetcourts.feed.PostList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import colman.android.streetcourts.model.Model;
import colman.android.streetcourts.model.Post;

import java.util.List;

public class PostListViewModel extends ViewModel {
    LiveData<List<Post>> data;
    LiveData<List<Post>> dataByCategory;
    LiveData<List<Post>> dataByMember;

    public PostListViewModel() {
        data = Model.instance.getAllPosts();
        dataByCategory = Model.instance.getPostsByCategory("");
        dataByMember = Model.instance.getPostsByMember("");
    }

    public LiveData<List<Post>> getData() {
        return data;
    }

    public LiveData<List<Post>> getDataByCategory(String category) {
        return dataByCategory;
    }

    public LiveData<List<Post>> getDataByMember(String memberId) {
        return dataByMember;
    }
}
