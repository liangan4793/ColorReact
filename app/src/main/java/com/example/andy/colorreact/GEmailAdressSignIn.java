package com.example.andy.colorreact;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GEmailAdressSignIn extends AppCompatActivity {

    @BindView(R.id.g_e_sign_in_button)Button signInButton;
    @BindView(R.id.g_e_email_address_edit_text)EditText emailAdress;
    @BindView(R.id.g_e_password_edit_text) EditText password;

    FirebaseAuth mauth;
    FirebaseUser mUser;
    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gemail_adress_sign_in);
        ButterKnife.bind(this);
        mauth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mauth.signInWithEmailAndPassword(emailAdress.getText().toString(),
                        password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            mUser = mauth.getCurrentUser();
                        }

                        else {
                            //TODO:
                        }
                    }
                });
                if (checkGoogleUser(mDatabase.getReference("UserList"), mUser.getDisplayName())) {
                    //TODO:
                    Intent welcomUserIntent()
                }
                else {

                }
            }
        });
    }

    public void

}
