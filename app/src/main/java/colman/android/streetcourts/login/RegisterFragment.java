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

import colman.android.streetcourts.login.RegisterFragmentDirections;

import colman.android.streetcourts.model.Member;
import colman.android.streetcourts.model.Model;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        Button registerBtn = view.findViewById(R.id.register_register_btn);
        TextInputEditText emailTil = view.findViewById(R.id.register_email_et);
        TextInputEditText passwordTil = view.findViewById(R.id.register_password_et);
        TextInputEditText firstNameTil = view.findViewById(R.id.register_firstname_et);
        TextInputEditText lastNameTil = view.findViewById(R.id.register_lastname_et);
        TextView loginTv = view.findViewById(R.id.register_login_tv);

        loginTv.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(RegisterFragmentDirections.actionGlobalLoginFragment());
        });

        registerBtn.setOnClickListener(v -> {
            Model.instance.register(emailTil.getEditableText().toString(),
                    passwordTil.getEditableText().toString(),
                    (user, error) -> {
                        if (user != null)
                            Model.instance.addMember(new Member
                                            (firstNameTil.getEditableText().toString() + " " + lastNameTil.getEditableText().toString(),
                                                    user.getUid(),
                                                    null,
                                                    user.getEmail(),
                                                    null,
                                                    Member.UserType.USER.toString()),
                                    () -> toFeedActivity());
                        else
                            Toast.makeText(this.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
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