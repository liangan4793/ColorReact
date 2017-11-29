package com.example.andy.colorreact.Utility;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Andy-m on 2017-11-22.
 */

public class Utility {

    /**
     * Checks weather or not the user is registered within the color react database.
     * @param database of users that are registered with ColorReact
     * @param user that is being checked
     * @return wheather or not the user is in the database.
     */
    private boolean googleAcountCheck(DatabaseReference database, FirebaseUser user){
        if(database.child("users").child(user.getEmail()) == null){
            return false;
        }
        else{
            return true;
        }
    }
}
