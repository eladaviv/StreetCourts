// Generated by view binder compiler. Do not edit!
package colman.android.streetcourts.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import colman.android.streetcourts.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPostBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout ScrollConstraintLayout;

  @NonNull
  public final TextView postAddressTxt;

  @NonNull
  public final TextView postAreaTxt;

  @NonNull
  public final TextView postCategoryTxt;

  @NonNull
  public final TextView postDescriptionTxt;

  @NonNull
  public final ImageView postMemberImgv;

  @NonNull
  public final TextView postNameTxt;

  @NonNull
  public final Button postToEditBtn;

  @NonNull
  public final ImageView postUserImageIv;

  @NonNull
  public final TextView postUserInfoTv;

  @NonNull
  public final ScrollView scrollView2;

  private FragmentPostBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout ScrollConstraintLayout, @NonNull TextView postAddressTxt,
      @NonNull TextView postAreaTxt, @NonNull TextView postCategoryTxt,
      @NonNull TextView postDescriptionTxt, @NonNull ImageView postMemberImgv,
      @NonNull TextView postNameTxt, @NonNull Button postToEditBtn,
      @NonNull ImageView postUserImageIv, @NonNull TextView postUserInfoTv,
      @NonNull ScrollView scrollView2) {
    this.rootView = rootView;
    this.ScrollConstraintLayout = ScrollConstraintLayout;
    this.postAddressTxt = postAddressTxt;
    this.postAreaTxt = postAreaTxt;
    this.postCategoryTxt = postCategoryTxt;
    this.postDescriptionTxt = postDescriptionTxt;
    this.postMemberImgv = postMemberImgv;
    this.postNameTxt = postNameTxt;
    this.postToEditBtn = postToEditBtn;
    this.postUserImageIv = postUserImageIv;
    this.postUserInfoTv = postUserInfoTv;
    this.scrollView2 = scrollView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_post, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ScrollConstraintLayout;
      ConstraintLayout ScrollConstraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (ScrollConstraintLayout == null) {
        break missingId;
      }

      id = R.id.post_address_txt;
      TextView postAddressTxt = ViewBindings.findChildViewById(rootView, id);
      if (postAddressTxt == null) {
        break missingId;
      }

      id = R.id.post_area_txt;
      TextView postAreaTxt = ViewBindings.findChildViewById(rootView, id);
      if (postAreaTxt == null) {
        break missingId;
      }

      id = R.id.post_category_txt;
      TextView postCategoryTxt = ViewBindings.findChildViewById(rootView, id);
      if (postCategoryTxt == null) {
        break missingId;
      }

      id = R.id.post_description_txt;
      TextView postDescriptionTxt = ViewBindings.findChildViewById(rootView, id);
      if (postDescriptionTxt == null) {
        break missingId;
      }

      id = R.id.post_member_imgv;
      ImageView postMemberImgv = ViewBindings.findChildViewById(rootView, id);
      if (postMemberImgv == null) {
        break missingId;
      }

      id = R.id.post_name_txt;
      TextView postNameTxt = ViewBindings.findChildViewById(rootView, id);
      if (postNameTxt == null) {
        break missingId;
      }

      id = R.id.post_to_edit_btn;
      Button postToEditBtn = ViewBindings.findChildViewById(rootView, id);
      if (postToEditBtn == null) {
        break missingId;
      }

      id = R.id.post_user_image_iv;
      ImageView postUserImageIv = ViewBindings.findChildViewById(rootView, id);
      if (postUserImageIv == null) {
        break missingId;
      }

      id = R.id.post_user_info_tv;
      TextView postUserInfoTv = ViewBindings.findChildViewById(rootView, id);
      if (postUserInfoTv == null) {
        break missingId;
      }

      id = R.id.scrollView2;
      ScrollView scrollView2 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView2 == null) {
        break missingId;
      }

      return new FragmentPostBinding((ConstraintLayout) rootView, ScrollConstraintLayout,
          postAddressTxt, postAreaTxt, postCategoryTxt, postDescriptionTxt, postMemberImgv,
          postNameTxt, postToEditBtn, postUserImageIv, postUserInfoTv, scrollView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
