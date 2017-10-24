package com.example.andy.colorreact;

import io.realm.RealmObject;

/**
 * Created by andy on 23/10/17.
 */

public class User {

    private String firstName;
    private String lastName;
    private int highSchore;

    public User() {
        firstName = null;
        lastName = null;
        highSchore = 0;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
