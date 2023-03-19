package colman.android.streetcourts.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import colman.android.streetcourts.R;
import colman.android.streetcourts.feed.MainDrawerActivity;

import colman.android.streetcourts.login.LoginFragmentDirections;

import colman.android.streetcourts.model.Model;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginBtn = view.findViewById(R.id.login_login_btn);
        TextInputEditText emailTil = view.findViewById(R.id.login_email_et);
        TextInputEditText passwordTil = view.findViewById(R.id.login_password_et);
        TextView registerTv = view.findViewById(R.id.login_register_tv);

        registerTv.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(LoginFragmentDirections.actionGlobalRegisterFragment());
        });

        loginBtn.setOnClickListener(v -> {
            Model.instance.signIn(emailTil.getEditableText().toString(),
                    passwordTil.getEditableText().toString(),
                    (user, error) -> {
                        if (user != null)
                            toFeedActivity();
                        else
                            Toast.makeText(this.getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    });
        });
        return view;
    }

    private void toFeedActivity() {
        Intent intent = new Intent(getContext(), MainDrawerActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}