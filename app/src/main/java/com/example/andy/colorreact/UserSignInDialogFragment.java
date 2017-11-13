package com.example.andy.colorreact;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AndyDesk on 11/11/2017.
 */

public class UserSignInDialogFragment extends DialogFragment {

    @BindView(R.id.fragment_user_sign_in_register_button)
    Button registerButton;
    @BindView(R.id.fragment_user_sign_in_sign_in_button)
    Button signInButton;

    public UserSignInDialogFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_sign_in, container);
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
                RegisterUserDialogFragment registerUserDialogFragment = new RegisterUserDialogFragment();
                registerUserDialogFragment.show(getFragmentManager(), "Register User");
                dismiss();
            }
        });

    }
}
