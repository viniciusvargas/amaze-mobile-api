package mobi.inspire.amaze.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("test")
public class TestEndpoint {
	
	@GET
    public Response testService() {
    	return Response.status(200).build();
    }
}
