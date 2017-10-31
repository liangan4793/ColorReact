package com.example.andy.colorreact;

import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.andy.colorreact.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements RegisterUserDialogFragment.RegisterUserDialogListener {

    @BindView(R.id.mainMenuSignInButton) Button signInButton;
    DatabaseReference database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.activity_menu, null);
        setContentView(view);
        ButterKnife.bind(this, view);

        if(savedInstanceState == null) {
            signInButton.setText("Sign In");
        }

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUserDialogFragment registerUserDialogFragment = new RegisterUserDialogFragment();
                registerUserDialogFragment.show(getFragmentManager(), "Register User");
            }
        });
    }

    @Override
    public void onRegisterUser(User user) {
        database = FirebaseDatabase.getInstance().getReference();
        database.child("Users").child(user.getUserName()).setValue(user);
    }
}
