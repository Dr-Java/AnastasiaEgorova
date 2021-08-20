package com.epam.tc.hw5.entity;

public class User {

    private final String username;
    private final String password;
    private String expectedUsername;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedUsername() {
        return expectedUsername;
    }
}
