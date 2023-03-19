package colman.android.streetcourts.feed.PostList;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class UserPostListRvFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private UserPostListRvFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private UserPostListRvFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static UserPostListRvFragmentArgs fromBundle(@NonNull Bundle bundle) {
    UserPostListRvFragmentArgs __result = new UserPostListRvFragmentArgs();
    bundle.setClassLoader(UserPostListRvFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("userId")) {
      String userId;
      userId = bundle.getString("userId");
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("userId", userId);
    } else {
      throw new IllegalArgumentException("Required argument \"userId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static UserPostListRvFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    UserPostListRvFragmentArgs __result = new UserPostListRvFragmentArgs();
    if (savedStateHandle.contains("userId")) {
      String userId;
      userId = savedStateHandle.get("userId");
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("userId", userId);
    } else {
      throw new IllegalArgumentException("Required argument \"userId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getUserId() {
    return (String) arguments.get("userId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("userId")) {
      String userId = (String) arguments.get("userId");
      __result.putString("userId", userId);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("userId")) {
      String userId = (String) arguments.get("userId");
      __result.set("userId", userId);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    UserPostListRvFragmentArgs that = (UserPostListRvFragmentArgs) object;
    if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
      return false;
    }
    if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserPostListRvFragmentArgs{"
        + "userId=" + getUserId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull UserPostListRvFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userId", userId);
    }

    @NonNull
    public UserPostListRvFragmentArgs build() {
      UserPostListRvFragmentArgs result = new UserPostListRvFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setUserId(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userId", userId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getUserId() {
      return (String) arguments.get("userId");
    }
  }
}
