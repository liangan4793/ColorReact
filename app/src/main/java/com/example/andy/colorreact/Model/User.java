package com.example.andy.colorreact.Model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by andy on 23/10/17.
 */

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String userName;
    private String emailAddress;
    private String password;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHighSchore(int highSchore) {
        this.highSchore = highSchore;
    }

    public String getUserName() {

        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public int getHighSchore() {
        return highSchore;
    }
}
