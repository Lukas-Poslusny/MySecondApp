package cz.educanet.web;


import sun.security.util.Password;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.xml.registry.infomodel.User;
import java.util.ArrayList;

@ApplicationScoped
public class UsersManager {

    private final ArrayList<Users> usersList = new ArrayList<Users>();


    public ArrayList<Users> getUsers() {
        return usersList;
    }


    public Response createUser(String fullName, String email, String Username, String password) {
        Users tempUser = new Users(fullName, email, Username, password);
        if (doesUserExist(tempUser)) {
            return Response.status(Response.Status.valueOf("User already exists!")).build();
        }
        return Response.ok("New user created").build();
    }

    public boolean doesUserExist(Users user) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
