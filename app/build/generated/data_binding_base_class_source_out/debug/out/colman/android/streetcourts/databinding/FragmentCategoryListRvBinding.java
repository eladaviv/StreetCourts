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

public final class FragmentCategoryListRvBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView categorylistRv;

  @NonNull
  public final SwipeRefreshLayout categorylistSwiperefresh;

  private FragmentCategoryListRvBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView categorylistRv, @NonNull SwipeRefreshLayout categorylistSwiperefresh) {
    this.rootView = rootView;
    this.categorylistRv = categorylistRv;
    this.categorylistSwiperefresh = categorylistSwiperefresh;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCategoryListRvBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCategoryListRvBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_category_list_rv, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCategoryListRvBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.categorylist_rv;
      RecyclerView categorylistRv = ViewBindings.findChildViewById(rootView, id);
      if (categorylistRv == null) {
        break missingId;
      }

      id = R.id.categorylist_swiperefresh;
      SwipeRefreshLayout categorylistSwiperefresh = ViewBindings.findChildViewById(rootView, id);
      if (categorylistSwiperefresh == null) {
        break missingId;
      }

      return new FragmentCategoryListRvBinding((ConstraintLayout) rootView, categorylistRv,
          categorylistSwiperefresh);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
