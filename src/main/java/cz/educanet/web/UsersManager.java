package cz.educanet.web;

import sun.security.util.Password;

import javax.xml.registry.infomodel.User;
import java.util.ArrayList;

public class UsersManager {

    private ArrayList<String> users = new ArrayList<>();

    private String email;
    private String username;
    private String password;

    public UsersManager(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<String> getAll() {
        return users;
    }
}
