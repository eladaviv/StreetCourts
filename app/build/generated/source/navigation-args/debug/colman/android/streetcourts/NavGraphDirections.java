package colman.android.streetcourts;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class NavGraphDirections {
  private NavGraphDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalMemberListRvFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_memberListRvFragment);
  }

  @NonNull
  public static NavDirections actionGlobalPostListRvFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_postListRvFragment);
  }

  @NonNull
  public static ActionGlobalPostFragment actionGlobalPostFragment(@NonNull String postId,
      @NonNull String postUId) {
    return new ActionGlobalPostFragment(postId, postUId);
  }

  @NonNull
  public static NavDirections actionGlobalAddPostFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_addPostFragment);
  }

  @NonNull
  public static ActionGlobalEditPostFragment actionGlobalEditPostFragment(@NonNull String postId,
      @NonNull String postUId) {
    return new ActionGlobalEditPostFragment(postId, postUId);
  }

  @NonNull
  public static NavDirections actionGlobalAddCategoryFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_addCategoryFragment);
  }

  @NonNull
  public static NavDirections actionGlobalCategoryListRvFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_categoryListRvFragment);
  }

  @NonNull
  public static ActionGlobalUserPostListRvFragment actionGlobalUserPostListRvFragment(
      @NonNull String userId) {
    return new ActionGlobalUserPostListRvFragment(userId);
  }

  @NonNull
  public static ActionGlobalCategoryPostListRvFragment actionGlobalCategoryPostListRvFragment() {
    return new ActionGlobalCategoryPostListRvFragment();
  }

  @NonNull
  public static ActionGlobalMemberDetailsFragment actionGlobalMemberDetailsFragment(
      @NonNull String memberId, @Nullable String currMemberId) {
    return new ActionGlobalMemberDetailsFragment(memberId, currMemberId);
  }

  @NonNull
  public static NavDirections actionGlobalLocationsMapFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_LocationsMapFragment);
  }

  public static class ActionGlobalPostFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionGlobalPostFragment(@NonNull String postId, @NonNull String postUId) {
      if (postId == null) {
        throw new IllegalArgumentException("Argument \"postId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postId", postId);
      if (postUId == null) {
        throw new IllegalArgumentException("Argument \"postUId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postUId", postUId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalPostFragment setPostId(@NonNull String postId) {
      if (postId == null) {
        throw new IllegalArgumentException("Argument \"postId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postId", postId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalPostFragment setPostUId(@NonNull String postUId) {
      if (postUId == null) {
        throw new IllegalArgumentException("Argument \"postUId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postUId", postUId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("postId")) {
        String postId = (String) arguments.get("postId");
        __result.putString("postId", postId);
      }
      if (arguments.containsKey("postUId")) {
        String postUId = (String) arguments.get("postUId");
        __result.putString("postUId", postUId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_global_postFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPostId() {
      return (String) arguments.get("postId");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPostUId() {
      return (String) arguments.get("postUId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionGlobalPostFragment that = (ActionGlobalPostFragment) object;
      if (arguments.containsKey("postId") != that.arguments.containsKey("postId")) {
        return false;
      }
      if (getPostId() != null ? !getPostId().equals(that.getPostId()) : that.getPostId() != null) {
        return false;
      }
      if (arguments.containsKey("postUId") != that.arguments.containsKey("postUId")) {
        return false;
      }
      if (getPostUId() != null ? !getPostUId().equals(that.getPostUId()) : that.getPostUId() != null) {
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
      result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
      result = 31 * result + (getPostUId() != null ? getPostUId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionGlobalPostFragment(actionId=" + getActionId() + "){"
          + "postId=" + getPostId()
          + ", postUId=" + getPostUId()
          + "}";
    }
  }

  public static class ActionGlobalEditPostFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionGlobalEditPostFragment(@NonNull String postId, @NonNull String postUId) {
      if (postId == null) {
        throw new IllegalArgumentException("Argument \"postId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postId", postId);
      if (postUId == null) {
        throw new IllegalArgumentException("Argument \"postUId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postUId", postUId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalEditPostFragment setPostId(@NonNull String postId) {
      if (postId == null) {
        throw new IllegalArgumentException("Argument \"postId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postId", postId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalEditPostFragment setPostUId(@NonNull String postUId) {
      if (postUId == null) {
        throw new IllegalArgumentException("Argument \"postUId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postUId", postUId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("postId")) {
        String postId = (String) arguments.get("postId");
        __result.putString("postId", postId);
      }
      if (arguments.containsKey("postUId")) {
        String postUId = (String) arguments.get("postUId");
        __result.putString("postUId", postUId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_global_editPostFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPostId() {
      return (String) arguments.get("postId");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPostUId() {
      return (String) arguments.get("postUId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionGlobalEditPostFragment that = (ActionGlobalEditPostFragment) object;
      if (arguments.containsKey("postId") != that.arguments.containsKey("postId")) {
        return false;
      }
      if (getPostId() != null ? !getPostId().equals(that.getPostId()) : that.getPostId() != null) {
        return false;
      }
      if (arguments.containsKey("postUId") != that.arguments.containsKey("postUId")) {
        return false;
      }
      if (getPostUId() != null ? !getPostUId().equals(that.getPostUId()) : that.getPostUId() != null) {
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
      result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
      result = 31 * result + (getPostUId() != null ? getPostUId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionGlobalEditPostFragment(actionId=" + getActionId() + "){"
          + "postId=" + getPostId()
          + ", postUId=" + getPostUId()
          + "}";
    }
  }

  public static class ActionGlobalUserPostListRvFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionGlobalUserPostListRvFragment(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userId", userId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalUserPostListRvFragment setUserId(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userId", userId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("userId")) {
        String userId = (String) arguments.get("userId");
        __result.putString("userId", userId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_global_userPostListRvFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUserId() {
      return (String) arguments.get("userId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionGlobalUserPostListRvFragment that = (ActionGlobalUserPostListRvFragment) object;
      if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
        return false;
      }
      if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) {
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
      result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionGlobalUserPostListRvFragment(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + "}";
    }
  }

  public static class ActionGlobalCategoryPostListRvFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionGlobalCategoryPostListRvFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalCategoryPostListRvFragment setCategoryName(@NonNull String categoryName) {
      if (categoryName == null) {
        throw new IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("categoryName", categoryName);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("categoryName")) {
        String categoryName = (String) arguments.get("categoryName");
        __result.putString("categoryName", categoryName);
      } else {
        __result.putString("categoryName", "");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_global_categoryPostListRvFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getCategoryName() {
      return (String) arguments.get("categoryName");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionGlobalCategoryPostListRvFragment that = (ActionGlobalCategoryPostListRvFragment) object;
      if (arguments.containsKey("categoryName") != that.arguments.containsKey("categoryName")) {
        return false;
      }
      if (getCategoryName() != null ? !getCategoryName().equals(that.getCategoryName()) : that.getCategoryName() != null) {
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
      result = 31 * result + (getCategoryName() != null ? getCategoryName().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionGlobalCategoryPostListRvFragment(actionId=" + getActionId() + "){"
          + "categoryName=" + getCategoryName()
          + "}";
    }
  }

  public static class ActionGlobalMemberDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionGlobalMemberDetailsFragment(@NonNull String memberId,
        @Nullable String currMemberId) {
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("memberId", memberId);
      this.arguments.put("currMemberId", currMemberId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalMemberDetailsFragment setMemberId(@NonNull String memberId) {
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("memberId", memberId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGlobalMemberDetailsFragment setCurrMemberId(@Nullable String currMemberId) {
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
      return R.id.action_global_memberDetailsFragment;
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
      ActionGlobalMemberDetailsFragment that = (ActionGlobalMemberDetailsFragment) object;
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
      return "ActionGlobalMemberDetailsFragment(actionId=" + getActionId() + "){"
          + "memberId=" + getMemberId()
          + ", currMemberId=" + getCurrMemberId()
          + "}";
    }
  }
}
