package example.stacktrace.app;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    public TestResource() {
    }

    @GET
    @Timed
    public String sayHello(@QueryParam("name") String name) {
        if(true) {
            throw new WebApplicationException("test exception");
        }
        return null;
    }
}
