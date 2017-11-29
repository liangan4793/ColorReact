package com.example.andy.colorreact.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.andy.colorreact.GoogleSignInActivity;
import com.example.andy.colorreact.Model.User;
import com.example.andy.colorreact.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomUserDialogFragment extends DialogFragment {

    @BindView(R.id.welcome_user_dialog_fragment_color_react_image) ImageView colorReactIcon;
    @BindView(R.id.welcome_user_dialog_fragment_main_menu_button) Button mainMenuButton;
    @BindView(R.id.welcome_user_dialog_fragment_sign_out_button) Button signOutButton;

    User currentUser;

    public WelcomUserDialogFragment(){}

    public interface WelcomUserDialogFragmentListener {

        public void passUserData();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment;
        View view = inflater.inflate(R.layout.fragment_welcom_user_dialog, container, false);
        ButterKnife.bind(this, view);
        currentUser = (User) savedInstanceState.get("User");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passUserData();
                dismiss();
            }
        });
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


    public void passUserData() {
        WelcomUserDialogFragmentListener listener = (WelcomUserDialogFragmentListener) getActivity();
        listener.passUserData();
        dismiss();
    }
}
