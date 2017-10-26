package com.example.andy.colorreact;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andy on 24/10/17.
 */

public class RegisterUserDialogFragment extends DialogFragment {
    @BindView(R.id.register_fragment_first_name)  EditText firstName;
    @BindView(R.id.register_fragment_last_name)  EditText lastName;
    @BindView(R.id.register_fragment_user_name)  EditText userName;
    @BindView(R.id.register_fragment_email_address)  EditText emailAddress;
    @BindView(R.id.register_fragment_password)  EditText password;
    @BindView(R.id.register_fragment_register_button)  Button registerButton;

    private User newUser;

    public interface RegisterUserDialogListener {
        void onRegisterUser(User user);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_user, container);
        ButterKnife.bind(this, view);
        return inflater.inflate(R.layout.fragment_register_user, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(newUser);
            }
        });

    }

    private void registerUser(User user) {
        user.setFirstName(firstName.getText().toString());
        user.setLastName(lastName.getText().toString());
        user.setUserName(userName.getText().toString());
        user.setEmailAddress(emailAddress.getText().toString());
        user.setPassword(password.getText().toString());

        RegisterUserDialogListener listener = (RegisterUserDialogListener) getActivity();
        listener.onRegisterUser(user);
        dismiss();
    }
}
