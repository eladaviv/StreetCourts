package colman.android.streetcourts.feed.MemberList;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import colman.android.streetcourts.NavGraphDirections;
import colman.android.streetcourts.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MemberListRvFragmentDirections {
  private MemberListRvFragmentDirections() {
  }

  @NonNull
  public static ActionMemberListRvFragmentToMemberDetailsFragment actionMemberListRvFragmentToMemberDetailsFragment(
      @NonNull String memberId, @Nullable String currMemberId) {
    return new ActionMemberListRvFragmentToMemberDetailsFragment(memberId, currMemberId);
  }

  @NonNull
  public static NavDirections actionGlobalMemberListRvFragment() {
    return NavGraphDirections.actionGlobalMemberListRvFragment();
  }

  @NonNull
  public static NavDirections actionGlobalPostListRvFragment() {
    return NavGraphDirections.actionGlobalPostListRvFragment();
  }

  @NonNull
  public static NavGraphDirections.ActionGlobalPostFragment actionGlobalPostFragment(
      @NonNull String postId, @NonNull String postUId) {
    return NavGraphDirections.actionGlobalPostFragment(postId, postUId);
  }

  @NonNull
  public static NavDirections actionGlobalAddPostFragment() {
    return NavGraphDirections.actionGlobalAddPostFragment();
  }

  @NonNull
  public static NavGraphDirections.ActionGlobalEditPostFragment actionGlobalEditPostFragment(
      @NonNull String postId, @NonNull String postUId) {
    return NavGraphDirections.actionGlobalEditPostFragment(postId, postUId);
  }

  @NonNull
  public static NavDirections actionGlobalAddCategoryFragment() {
    return NavGraphDirections.actionGlobalAddCategoryFragment();
  }

  @NonNull
  public static NavDirections actionGlobalCategoryListRvFragment() {
    return NavGraphDirections.actionGlobalCategoryListRvFragment();
  }

  @NonNull
  public static NavGraphDirections.ActionGlobalUserPostListRvFragment actionGlobalUserPostListRvFragment(
      @NonNull String userId) {
    return NavGraphDirections.actionGlobalUserPostListRvFragment(userId);
  }

  @NonNull
  public static NavGraphDirections.ActionGlobalCategoryPostListRvFragment actionGlobalCategoryPostListRvFragment(
      ) {
    return NavGraphDirections.actionGlobalCategoryPostListRvFragment();
  }

  @NonNull
  public static NavGraphDirections.ActionGlobalMemberDetailsFragment actionGlobalMemberDetailsFragment(
      @NonNull String memberId, @Nullable String currMemberId) {
    return NavGraphDirections.actionGlobalMemberDetailsFragment(memberId, currMemberId);
  }

  @NonNull
  public static NavDirections actionGlobalLocationsMapFragment() {
    return NavGraphDirections.actionGlobalLocationsMapFragment();
  }

  public static class ActionMemberListRvFragmentToMemberDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionMemberListRvFragmentToMemberDetailsFragment(@NonNull String memberId,
        @Nullable String currMemberId) {
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("memberId", memberId);
      this.arguments.put("currMemberId", currMemberId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionMemberListRvFragmentToMemberDetailsFragment setMemberId(@NonNull String memberId) {
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("memberId", memberId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionMemberListRvFragmentToMemberDetailsFragment setCurrMemberId(
        @Nullable String currMemberId) {
      this.arguments.put("currMemberId", currMemberId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("memberId")) {
        String memberId = (String) arguments.get("memberId");
        __result.putString("memberId", memberId);
      }
      if (arguments.containsKey("currMemberId")) {
        String currMemberId = (String) arguments.get("currMemberId");
        __result.putString("currMemberId", currMemberId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_memberListRvFragment_to_memberDetailsFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getMemberId() {
      return (String) arguments.get("memberId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCurrMemberId() {
      return (String) arguments.get("currMemberId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMemberListRvFragmentToMemberDetailsFragment that = (ActionMemberListRvFragmentToMemberDetailsFragment) object;
      if (arguments.containsKey("memberId") != that.arguments.containsKey("memberId")) {
        return false;
      }
      if (getMemberId() != null ? !getMemberId().equals(that.getMemberId()) : that.getMemberId() != null) {
        return false;
      }
      if (arguments.containsKey("currMemberId") != that.arguments.containsKey("currMemberId")) {
        return false;
      }
      if (getCurrMemberId() != null ? !getCurrMemberId().equals(that.getCurrMemberId()) : that.getCurrMemberId() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getMemberId() != null ? getMemberId().hashCode() : 0);
      result = 31 * result + (getCurrMemberId() != null ? getCurrMemberId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMemberListRvFragmentToMemberDetailsFragment(actionId=" + getActionId() + "){"
          + "memberId=" + getMemberId()
          + ", currMemberId=" + getCurrMemberId()
          + "}";
    }
  }
}
