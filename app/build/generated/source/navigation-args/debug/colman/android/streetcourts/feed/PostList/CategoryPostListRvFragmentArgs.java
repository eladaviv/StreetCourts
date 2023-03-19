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

public class CategoryPostListRvFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CategoryPostListRvFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CategoryPostListRvFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CategoryPostListRvFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CategoryPostListRvFragmentArgs __result = new CategoryPostListRvFragmentArgs();
    bundle.setClassLoader(CategoryPostListRvFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("categoryName")) {
      String categoryName;
      categoryName = bundle.getString("categoryName");
      if (categoryName == null) {
        throw new IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("categoryName", categoryName);
    } else {
      __result.arguments.put("categoryName", "");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CategoryPostListRvFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    CategoryPostListRvFragmentArgs __result = new CategoryPostListRvFragmentArgs();
    if (savedStateHandle.contains("categoryName")) {
      String categoryName;
      categoryName = savedStateHandle.get("categoryName");
      if (categoryName == null) {
        throw new IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("categoryName", categoryName);
    } else {
      __result.arguments.put("categoryName", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getCategoryName() {
    return (String) arguments.get("categoryName");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("categoryName")) {
      String categoryName = (String) arguments.get("categoryName");
      __result.putString("categoryName", categoryName);
    } else {
      __result.putString("categoryName", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("categoryName")) {
      String categoryName = (String) arguments.get("categoryName");
      __result.set("categoryName", categoryName);
    } else {
      __result.set("categoryName", "");
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
    CategoryPostListRvFragmentArgs that = (CategoryPostListRvFragmentArgs) object;
    if (arguments.containsKey("categoryName") != that.arguments.containsKey("categoryName")) {
      return false;
    }
    if (getCategoryName() != null ? !getCategoryName().equals(that.getCategoryName()) : that.getCategoryName() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getCategoryName() != null ? getCategoryName().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CategoryPostListRvFragmentArgs{"
        + "categoryName=" + getCategoryName()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CategoryPostListRvFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CategoryPostListRvFragmentArgs build() {
      CategoryPostListRvFragmentArgs result = new CategoryPostListRvFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setCategoryName(@NonNull String categoryName) {
      if (categoryName == null) {
        throw new IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("categoryName", categoryName);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getCategoryName() {
      return (String) arguments.get("categoryName");
    }
  }
}
