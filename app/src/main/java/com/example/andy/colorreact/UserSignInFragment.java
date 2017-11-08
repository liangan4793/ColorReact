package com.example.andy.colorreact;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andy on 07/11/17.
 */

public class UserSignInFragment extends DialogFragment {

    @BindView(R.id.fragment_user_sign_in_sign_in_button) Button signInButton;
    @BindView(R.id.fragment_user_sign_in_register_button) Button registerButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_sign_in, container);
        ButterKnife.bind(this, view);
        return inflater.inflate(R.layout.fragment_user_sign_in, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUserDialogFragment registerUserDialogFragment = new RegisterUserDialogFragment();
                registerUserDialogFragment.show(getFragmentManager(), "Register User");
            }
        });
    }
}
