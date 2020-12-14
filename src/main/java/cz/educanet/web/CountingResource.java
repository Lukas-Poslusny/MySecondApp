package cz.educanet.web;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("counter")
@Produces(MediaType.APPLICATION_JSON)
public class CountingResource {

    @Inject
    private CounterManager counterManager;

    @GET
    public Response getCounter() {
        int Count = counterManager.getCounter();
        return Response.ok("hello").build();
    }

    @POST
    public Response addOne() {
        counterManager.add();
        return Response.ok().build();
    }

}
