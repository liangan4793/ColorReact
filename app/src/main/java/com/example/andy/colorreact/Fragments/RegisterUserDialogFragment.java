package com.example.andy.colorreact.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.andy.colorreact.Model.User;
import com.example.andy.colorreact.R;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andy on 24/10/17.
 * Class the register and exisiting goolge acount with a color react account.
 */


public class RegisterUserDialogFragment extends DialogFragment {
    @BindView(R.id.register_fragment_user_name)  EditText displayName;
    @BindView(R.id.register_fragment_email_address)  EditText emailAddress;
    @BindView(R.id.register_fragment_password)  EditText password;
    @BindView(R.id.register_fragment_register_button)  Button registerButton;

    public RegisterUserDialogFragment() {}

    public interface RegisterUserDialogListener {
        void onRegisterUser(String displayName, String emailAdress, String password);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_user, container);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void registerUser() {

        RegisterUserDialogListener listener = (RegisterUserDialogListener) getActivity();
        listener.onRegisterUser(displayName.getText().toString(),
                emailAddress.getText().toString(),
                password.getText().toString());
        dismiss();
    }
}
