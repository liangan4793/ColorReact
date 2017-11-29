package com.example.andy.colorreact;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andy.colorreact.Fragments.RegisterUserDialogFragment;
import com.example.andy.colorreact.Fragments.UserSignInDialogFragment;
import com.example.andy.colorreact.Fragments.WelcomUserDialogFragment;
import com.example.andy.colorreact.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    //----REQUEST CODES----
    static final int USER_SIGN_OUT_REQUEST = 3;
    static final int GET_GOOGLE_USER_REQUEST = 2;

    //----Constants----
    static final String GOOGLE_USER = "Google User";

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
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentUser == null) {
                    Intent intent = new Intent(getApplicationContext(), GoogleSignInActivity.class);
                    startActivityForResult(intent, GET_GOOGLE_USER_REQUEST);
                }
                else{
//                    Intent intent = new Intent(getApplicationContext(), GoogleSignOutActivity.class);
//                    startActivityForResult(intent, USER_SIGN_OUT_REQUEST);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    //    @Override
//    public void onRegisterUser(String displayName, String emailAdress, String password) {
//
//        if(emailAdress != null && password != null) {
//            //Create a new user within firebase authentication.
//            FirebaseAuth auth = FirebaseAuth.getInstance();
//            auth.createUserWithEmailAndPassword(emailAdress, password);
//            FirebaseUser firebaseUser = auth.getCurrentUser();
//            if(displayName!= null) {
//                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
//                        .setDisplayName(displayName)
//                        .build();
//                firebaseUser.updateProfile(profileChangeRequest);
//            }
//            currentUser = new User();
//            currentUser.setUser(firebaseUser);
//            //Get a reference to the firebase database and insert the record.
//            database = FirebaseDatabase.getInstance().getReference();
//            database.child("Users").child(currentUser.getDisplayName()).setValue(currentUser);
//
//            updateUI(auth.getCurrentUser().getDisplayName());
//        }
//        else {
//            Toast toast = new Toast(getApplicationContext());
//            toast.setText("Invalid register");
//            toast.show();
//        }
//    }

    private void updateUI(String displayName) {
        signInButton.setText(displayName);
    }
}
