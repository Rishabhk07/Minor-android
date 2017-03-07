package com.example.rishabhkhanna.minor.models;

/**
 * Created by rishabhkhanna on 18/10/16.
 */

public class AuthCredits {
    private String name;
    private String email;
    private String password;


    public AuthCredits(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
