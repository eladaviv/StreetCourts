package colman.android.streetcourts.feed.Details;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MemberDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MemberDetailsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private MemberDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MemberDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MemberDetailsFragmentArgs __result = new MemberDetailsFragmentArgs();
    bundle.setClassLoader(MemberDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("memberId")) {
      String memberId;
      memberId = bundle.getString("memberId");
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("memberId", memberId);
    } else {
      throw new IllegalArgumentException("Required argument \"memberId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("currMemberId")) {
      String currMemberId;
      currMemberId = bundle.getString("currMemberId");
      __result.arguments.put("currMemberId", currMemberId);
    } else {
      throw new IllegalArgumentException("Required argument \"currMemberId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MemberDetailsFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    MemberDetailsFragmentArgs __result = new MemberDetailsFragmentArgs();
    if (savedStateHandle.contains("memberId")) {
      String memberId;
      memberId = savedStateHandle.get("memberId");
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("memberId", memberId);
    } else {
      throw new IllegalArgumentException("Required argument \"memberId\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("currMemberId")) {
      String currMemberId;
      currMemberId = savedStateHandle.get("currMemberId");
      __result.arguments.put("currMemberId", currMemberId);
    } else {
      throw new IllegalArgumentException("Required argument \"currMemberId\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("memberId")) {
      String memberId = (String) arguments.get("memberId");
      __result.set("memberId", memberId);
    }
    if (arguments.containsKey("currMemberId")) {
      String currMemberId = (String) arguments.get("currMemberId");
      __result.set("currMemberId", currMemberId);
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
    MemberDetailsFragmentArgs that = (MemberDetailsFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getMemberId() != null ? getMemberId().hashCode() : 0);
    result = 31 * result + (getCurrMemberId() != null ? getCurrMemberId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MemberDetailsFragmentArgs{"
        + "memberId=" + getMemberId()
        + ", currMemberId=" + getCurrMemberId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull MemberDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String memberId, @Nullable String currMemberId) {
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("memberId", memberId);
      this.arguments.put("currMemberId", currMemberId);
    }

    @NonNull
    public MemberDetailsFragmentArgs build() {
      MemberDetailsFragmentArgs result = new MemberDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setMemberId(@NonNull String memberId) {
      if (memberId == null) {
        throw new IllegalArgumentException("Argument \"memberId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("memberId", memberId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setCurrMemberId(@Nullable String currMemberId) {
      this.arguments.put("currMemberId", currMemberId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getMemberId() {
      return (String) arguments.get("memberId");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getCurrMemberId() {
      return (String) arguments.get("currMemberId");
    }
  }
}
