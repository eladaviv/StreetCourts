// Generated by view binder compiler. Do not edit!
package colman.android.streetcourts.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import colman.android.streetcourts.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentUserPostListRvBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView userPostlistRv;

  @NonNull
  public final SwipeRefreshLayout userPostlistSwiperefresh;

  private FragmentUserPostListRvBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView userPostlistRv, @NonNull SwipeRefreshLayout userPostlistSwiperefresh) {
    this.rootView = rootView;
    this.userPostlistRv = userPostlistRv;
    this.userPostlistSwiperefresh = userPostlistSwiperefresh;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentUserPostListRvBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentUserPostListRvBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_user_post_list_rv, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentUserPostListRvBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.user_postlist_rv;
      RecyclerView userPostlistRv = ViewBindings.findChildViewById(rootView, id);
      if (userPostlistRv == null) {
        break missingId;
      }

      id = R.id.user_postlist_swiperefresh;
      SwipeRefreshLayout userPostlistSwiperefresh = ViewBindings.findChildViewById(rootView, id);
      if (userPostlistSwiperefresh == null) {
        break missingId;
      }

      return new FragmentUserPostListRvBinding((ConstraintLayout) rootView, userPostlistRv,
          userPostlistSwiperefresh);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
