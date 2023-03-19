package colman.android.streetcourts.feed.MemberList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import colman.android.streetcourts.model.Member;
import colman.android.streetcourts.model.Model;

import java.util.List;

public class MemberListRvViewModel extends ViewModel {
    LiveData<List<Member>> data;

    public MemberListRvViewModel() {
        data = Model.instance.getAllMembers();
    }

    public LiveData<List<Member>> getData() {
        return data;
    }

}
