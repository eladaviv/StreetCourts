package colman.android.streetcourts.feed.Post;

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

public class PostFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PostFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private PostFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PostFragmentArgs fromBundle(@NonNull Bundle bundle) {
    PostFragmentArgs __result = new PostFragmentArgs();
    bundle.setClassLoader(PostFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("postId")) {
      String postId;
      postId = bundle.getString("postId");
      if (postId == null) {
        throw new IllegalArgumentException("Argument \"postId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("postId", postId);
    } else {
      throw new IllegalArgumentException("Required argument \"postId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("postUId")) {
      String postUId;
      postUId = bundle.getString("postUId");
      if (postUId == null) {
        throw new IllegalArgumentException("Argument \"postUId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("postUId", postUId);
    } else {
      throw new IllegalArgumentException("Required argument \"postUId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PostFragmentArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    PostFragmentArgs __result = new PostFragmentArgs();
    if (savedStateHandle.contains("postId")) {
      String postId;
      postId = savedStateHandle.get("postId");
      if (postId == null) {
        throw new IllegalArgumentException("Argument \"postId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("postId", postId);
    } else {
      throw new IllegalArgumentException("Required argument \"postId\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("postUId")) {
      String postUId;
      postUId = savedStateHandle.get("postUId");
      if (postUId == null) {
        throw new IllegalArgumentException("Argument \"postUId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("postUId", postUId);
    } else {
      throw new IllegalArgumentException("Required argument \"postUId\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("postId")) {
      String postId = (String) arguments.get("postId");
      __result.set("postId", postId);
    }
    if (arguments.containsKey("postUId")) {
      String postUId = (String) arguments.get("postUId");
      __result.set("postUId", postUId);
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
    PostFragmentArgs that = (PostFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
    result = 31 * result + (getPostUId() != null ? getPostUId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "PostFragmentArgs{"
        + "postId=" + getPostId()
        + ", postUId=" + getPostUId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull PostFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String postId, @NonNull String postUId) {
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
    public PostFragmentArgs build() {
      PostFragmentArgs result = new PostFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPostId(@NonNull String postId) {
      if (postId == null) {
        throw new IllegalArgumentException("Argument \"postId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postId", postId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPostUId(@NonNull String postUId) {
      if (postUId == null) {
        throw new IllegalArgumentException("Argument \"postUId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("postUId", postUId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getPostId() {
      return (String) arguments.get("postId");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getPostUId() {
      return (String) arguments.get("postUId");
    }
  }
}
