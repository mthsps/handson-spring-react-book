package com.org.cardatabase.model;

public class AccountCredentials {

    private String username;
    private String password;

    public AccountCredentials() {}

    public AccountCredentials(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}