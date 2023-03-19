package colman.android.streetcourts.feed.Edit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import colman.android.streetcourts.model.Member;
import colman.android.streetcourts.model.Model;

public class EditViewModel extends ViewModel {
    LiveData<Member> data;

    public EditViewModel() {
        data = new MutableLiveData<Member>();
    }

    public LiveData<Member> getData(String id) {
        data = Model.instance.getMemberById(id);
        return data;
    }
}
