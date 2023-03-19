package colman.android.streetcourts;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class LoginNavGraphDirections {
  private LoginNavGraphDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_loginFragment);
  }

  @NonNull
  public static NavDirections actionGlobalRegisterFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_registerFragment);
  }
}
