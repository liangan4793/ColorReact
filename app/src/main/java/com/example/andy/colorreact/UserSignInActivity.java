package com.example.andy.colorreact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserSignInActivity extends AppCompatActivity {
    @BindView(R.id.activity_user_sign_in_sign_in_button)
    TextView signInButton;
    @BindView(R.id.activity_user_sign_in_sign_in_with_google_button)
    Button signInWithGoogleButton;
    @BindView(R.id.activity_user_sign_in_sign_up_button)
    Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in);
        ButterKnife.bind(this);

        signInWithGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Start fragment to choose google account or add google account
            }
        });
    }
}
