// Generated by view binder compiler. Do not edit!
package colman.android.streetcourts.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import colman.android.streetcourts.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEditBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputEditText editAddressTxt;

  @NonNull
  public final ImageButton editCameraBtn;

  @NonNull
  public final Button editCancelBtn;

  @NonNull
  public final Button editDeleteBtn;

  @NonNull
  public final ImageButton editGalleryBtn;

  @NonNull
  public final TextInputEditText editLastnameTxt;

  @NonNull
  public final ImageView editMemberImgv;

  @NonNull
  public final TextInputEditText editNameTxt;

  @NonNull
  public final TextInputEditText editPhoneTxt;

  @NonNull
  public final ProgressBar editProgressbar;

  @NonNull
  public final Button editSaveBtn;

  @NonNull
  public final LinearLayout linearLayout3;

  private FragmentEditBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextInputEditText editAddressTxt, @NonNull ImageButton editCameraBtn,
      @NonNull Button editCancelBtn, @NonNull Button editDeleteBtn,
      @NonNull ImageButton editGalleryBtn, @NonNull TextInputEditText editLastnameTxt,
      @NonNull ImageView editMemberImgv, @NonNull TextInputEditText editNameTxt,
      @NonNull TextInputEditText editPhoneTxt, @NonNull ProgressBar editProgressbar,
      @NonNull Button editSaveBtn, @NonNull LinearLayout linearLayout3) {
    this.rootView = rootView;
    this.editAddressTxt = editAddressTxt;
    this.editCameraBtn = editCameraBtn;
    this.editCancelBtn = editCancelBtn;
    this.editDeleteBtn = editDeleteBtn;
    this.editGalleryBtn = editGalleryBtn;
    this.editLastnameTxt = editLastnameTxt;
    this.editMemberImgv = editMemberImgv;
    this.editNameTxt = editNameTxt;
    this.editPhoneTxt = editPhoneTxt;
    this.editProgressbar = editProgressbar;
    this.editSaveBtn = editSaveBtn;
    this.linearLayout3 = linearLayout3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_edit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEditBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.edit_address_txt;
      TextInputEditText editAddressTxt = ViewBindings.findChildViewById(rootView, id);
      if (editAddressTxt == null) {
        break missingId;
      }

      id = R.id.edit_camera_btn;
      ImageButton editCameraBtn = ViewBindings.findChildViewById(rootView, id);
      if (editCameraBtn == null) {
        break missingId;
      }

      id = R.id.edit_cancel_btn;
      Button editCancelBtn = ViewBindings.findChildViewById(rootView, id);
      if (editCancelBtn == null) {
        break missingId;
      }

      id = R.id.edit_delete_btn;
      Button editDeleteBtn = ViewBindings.findChildViewById(rootView, id);
      if (editDeleteBtn == null) {
        break missingId;
      }

      id = R.id.edit_gallery_btn;
      ImageButton editGalleryBtn = ViewBindings.findChildViewById(rootView, id);
      if (editGalleryBtn == null) {
        break missingId;
      }

      id = R.id.edit_lastname_txt;
      TextInputEditText editLastnameTxt = ViewBindings.findChildViewById(rootView, id);
      if (editLastnameTxt == null) {
        break missingId;
      }

      id = R.id.edit_member_imgv;
      ImageView editMemberImgv = ViewBindings.findChildViewById(rootView, id);
      if (editMemberImgv == null) {
        break missingId;
      }

      id = R.id.edit_name_txt;
      TextInputEditText editNameTxt = ViewBindings.findChildViewById(rootView, id);
      if (editNameTxt == null) {
        break missingId;
      }

      id = R.id.edit_phone_txt;
      TextInputEditText editPhoneTxt = ViewBindings.findChildViewById(rootView, id);
      if (editPhoneTxt == null) {
        break missingId;
      }

      id = R.id.edit_progressbar;
      ProgressBar editProgressbar = ViewBindings.findChildViewById(rootView, id);
      if (editProgressbar == null) {
        break missingId;
      }

      id = R.id.edit_save_btn;
      Button editSaveBtn = ViewBindings.findChildViewById(rootView, id);
      if (editSaveBtn == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      return new FragmentEditBinding((ConstraintLayout) rootView, editAddressTxt, editCameraBtn,
          editCancelBtn, editDeleteBtn, editGalleryBtn, editLastnameTxt, editMemberImgv,
          editNameTxt, editPhoneTxt, editProgressbar, editSaveBtn, linearLayout3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
