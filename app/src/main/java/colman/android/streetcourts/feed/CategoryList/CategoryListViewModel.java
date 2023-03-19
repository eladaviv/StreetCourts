package colman.android.streetcourts.feed.CategoryList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import colman.android.streetcourts.model.Category;
import colman.android.streetcourts.model.Model;

import java.util.List;

public class CategoryListViewModel extends ViewModel {
    LiveData<List<Category>> data;

    public CategoryListViewModel() {
        data = Model.instance.getAllCategories();
    }

    public LiveData<List<Category>> getData() {
        return data;
    }
}
