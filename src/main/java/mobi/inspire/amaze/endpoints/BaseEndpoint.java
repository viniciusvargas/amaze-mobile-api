package mobi.inspire.amaze.endpoints;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mobi.inspire.amaze.endpoints.model.BaseResponse;

import com.google.gson.Gson;

public abstract class BaseEndpoint {
	
	public Response ok(String response) {
		return Response.ok(response, MediaType.APPLICATION_JSON).build();
	}
}
