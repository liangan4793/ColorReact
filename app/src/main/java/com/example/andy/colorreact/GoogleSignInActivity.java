package com.example.andy.colorreact;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.andy.colorreact.Fragments.WelcomUserDialogFragment;
import com.example.andy.colorreact.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONObject;

import butterknife.BindView;

public class GoogleSignInActivity extends AppCompatActivity implements WelcomUserDialogFragment.WelcomUserDialogFragmentListener {

    @BindView(R.id.google_sign_in_activity_email_edit_text)
    EditText email;
    @BindView(R.id.google_sign_in_activity_password_edit_text)
    EditText password;
    @BindView(R.id.google_sign_in_activity_sign_in_button)
    Button signInButton;

    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    User currentUser;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_sign_in);
        database = FirebaseDatabase.getInstance().getReference();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUser(email.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void passUserData() {

    }

    public void setUser(String email, String password) {
       auth = FirebaseAuth.getInstance();
       auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()) {
                   firebaseUser = auth.getCurrentUser();
                   if(isColorReactUser(firebaseUser.getDisplayName())) {
                       currentUser = getUserFromDatabase(firebaseUser);
                       Intent returnIntent = new Intent();
                       returnIntent.putExtra("User", currentUser);
                       setResult(Activity.RESULT_OK, returnIntent);
                       finish();
                   }
                   else {
                       //TODO: start register dialog fragment
                   }
                   
               }
               else {
                   //TODO: What happens when the user put in incorrect google credentials
               }
           }
       });
    }

    /**
     *Checks whether or not the give firebase user is in the colrea react database.
     * @param userDisplayName
     * @return false if not a color react user and true otherwise.
     */
    private boolean isColorReactUser(String userDisplayName) {
        database.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })
        return false ;
    }

    private User getUserFromDatabase(FirebaseUser firebaseUser) {
        //TODO: Fetch user from database. As well as handle the exception in which the user does not exist within
        //TODO: the database-----------
        database.child("users").child()
        return null;
    }

}
