package com.example.andy.colorreact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
    User currentUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.activity_menu, null);
        setContentView(view);
        ButterKnife.bind(this, view);

        if(savedInstanceState == null) {
            signInButton.setText("Sign In");
        }
        else {
            currentUser = (User) savedInstanceState.getSerializable("Saved User");

        }

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:
                UserSignInDialogFragment userSignInDialogFragment = new UserSignInDialogFragment();
                userSignInDialogFragment.show(getFragmentManager(), "User sign in");
            }
        });
    }

    @Override
    public void onRegisterUser(User user) {
        currentUser = user;
        database = FirebaseDatabase.getInstance().getReference();
        database.child("Users").child(user.getUserName()).setValue(user);
        signInButton.setText(user.getUserName());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("Saved User", currentUser);
    }
}
