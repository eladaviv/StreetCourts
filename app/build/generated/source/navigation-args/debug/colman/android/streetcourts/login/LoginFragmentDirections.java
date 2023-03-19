package colman.android.streetcourts.login;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import colman.android.streetcourts.LoginNavGraphDirections;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalLoginFragment() {
    return LoginNavGraphDirections.actionGlobalLoginFragment();
  }

  @NonNull
  public static NavDirections actionGlobalRegisterFragment() {
    return LoginNavGraphDirections.actionGlobalRegisterFragment();
  }
}
