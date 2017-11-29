package com.example.andy.colorreact.Model;

import com.google.firebase.auth.FirebaseUser;
import java.io.Serializable;

/**
 * Created by andy on 23/10/17.
 */

public class User implements Serializable {

    //--Constants
    private static final String NO_FIREBASE_USER = "No Firebase User";

    FirebaseUser user;
    private int highSchore;
    private boolean isFirebaseUser;

    public User() {
        isFirebaseUser = false;
        highSchore = 0;
    }

    public void setUser(FirebaseUser user) {
        this.user = user;
        isFirebaseUser = true;
    }

    public void setHighSchore(int highSchore) {
        this.highSchore = highSchore;
    }

    public FirebaseUser getUser() {
        return user;
    }

    public int getHighSchore() {
        return highSchore;
    }

    public boolean containsFirebaseUser() {
        return isFirebaseUser;
    }

    public void setIsFirebaseUser(boolean x) {
        isFirebaseUser = x;
    }

    public String getDisplayName(){
        if(user.getDisplayName() != null) {
            return user.getDisplayName();
        }
        else {
            return getEmail();
        }
    }

    public String getEmail(){
        return user.getEmail();
    }

}
