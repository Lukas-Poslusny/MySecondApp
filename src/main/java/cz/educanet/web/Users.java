package cz.educanet.web;

import java.util.ArrayList;

public class Users {

    private String fullName;
    private String username;
    private String email;
    private String password;

    public Users(String fullName, String email, String username, String password) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFullname() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
