package cz.educanet.web;

import com.sun.tools.javac.comp.Todo;
import org.graalvm.compiler.graph.Node;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AuthenticationManager {

    @Inject
    private UsersManager usersManager;

    private final ArrayList<Users> tempUsers = usersManager.getUsers();
    private final ArrayList<Users> loggedUsers = new ArrayList<>();


    @GET
    public Response getLoggedUsers() {
        return Response.ok(loggedUsers).build();
    }


    @POST
    public Response registerUser(String fullName, String email, String username, String password) {
        Users tempUser = new Users(fullName, email, username, password);
        if (doesUserExist(tempUser)) {
            usersManager.createUser(fullName, email, username, password);
            return Response.ok().build();
        }
        return Response.status(Response.Status.valueOf("User does not exist")).build();
    }


    @POST
    public Response loginUser(String username, String password) {
        Users tempUser = new Users("", "", username, password);

        if (doesUserExist(tempUser)) {
            for (int i = 0; i < tempUsers.size(); i++) {
                if (tempUsers.get(i).getUsername().equals(tempUser.getUsername()) && tempUsers.get(i).getPassword().equals(tempUser.getPassword())) {
                    loggedUsers.add(tempUser);
                    return Response.ok("Successfully logged in").build();
                }
            }
        }
        return Response.status(Response.Status.valueOf("User does not exist")).build();
    }


    @DELETE
    public Response logoutUser(Users user) {
        for (int i = 0; i < tempUsers.size(); i++) {
            if (tempUsers.get(i).getUsername().equals(user.getUsername())) {
                loggedUsers.remove(user);
                return Response.ok("Successfully logged out").build();
            }
        }
        return Response.status(Response.Status.valueOf("Could not log user out.")).build();
    }


    public boolean doesUserExist(Users user) {
        for (int i = 0; i < loggedUsers.size(); i++) {
            if (loggedUsers.get(i).getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
