package colman.android.streetcourts.feed.LocationsMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import colman.android.streetcourts.NavGraphDirections;
import java.lang.String;

public class LocationsMapFragmentDirections {
  private LocationsMapFragmentDirections() {
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
}
