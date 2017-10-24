package com.example.andy.colorreact;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andy on 24/10/17.
 */

public class RegisterUserDialogFragment extends DialogFragment {
    @BindView(R.id.register_fragment_first_name) private EditText firstName;
    @BindView(R.id.register_fragment_last_name) private EditText lastName;
    @BindView(R.id.register_fragment_user_name) private EditText userName;
    @BindView(R.id.register_fragment_email_address) private EditText emailAddress;
    @BindView(R.id.register_fragment_password) private EditText password;

    public RegisterUserDialogFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_user, container, false);
        ButterKnife.bind(this, view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
