package cz.educanet.web;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.registry.infomodel.User;
import java.awt.*;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private static UsersManager usersManager = new UsersManager(email, username, password);

    public boolean doesUserExist(String user) {
        List<String> foundUsers = usersManager.getAll();
        for (int i = 0; i < foundUsers.size(); i++) {
            if (foundUsers.get(i).getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @GET
    @Path("{{name}}")
    public Response getUsers() {
        List<String> foundUsers = usersManager.getAll();
        return Response.ok(foundUsers).build();
    }

    @POST
    {}

    @PUT
    {}

    @DELETE
    {}

}
