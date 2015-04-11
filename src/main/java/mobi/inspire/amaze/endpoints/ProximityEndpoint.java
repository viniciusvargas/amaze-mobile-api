package mobi.inspire.amaze.endpoints;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import mobi.inspire.amaze.endpoints.constants.EndpointConstants;
import mobi.inspire.amaze.endpoints.model.FindBeaconRequest;
import mobi.inspiring.amaze.core.model.Beacon;
import mobi.inspiring.amaze.core.service.BeaconService;

public class ProximityEndpoint extends BaseEndpoint{
	
	BeaconService beaconService = null;
	
	public ProximityEndpoint() throws UnknownHostException{
		super();
	}
	
	@POST
    @Path("/notify_exit")
    @Produces("application/json")
    public Response notifyExitFromBeaconArea(String jsonBody) {
		JSONObject jsonRequest = new JSONObject(jsonBody);
		JSONObject jsonResponse = new JSONObject();

		if (jsonBody == null) {
			jsonResponse.put("systemMessage", EndpointConstants.EMPTY_REQUEST);
			return Response.ok(jsonResponse.toString(), MediaType.APPLICATION_JSON).build();
		}
		
		String uuid = jsonRequest.getString("uuid");
		String major = jsonRequest.getString("major");
		String minor = jsonRequest.getString("minor");
    	
    	Beacon beacon = new Beacon(uuid, major, minor);
    	beacon = beaconService.findByFilter(beacon).get(0);
    	//appService.notifyExitFromBeaconArea(beacon, request.userCode);
    	
    	//TODO: implement logic here
    	throw new UnsupportedOperationException("Not yet implemented");
    }
    
	@POST
    @Path("/notify_exit")
    @Produces("application/json")
    public Response notifyEntryInBeaconArea(String jsonBody) {
    	JSONObject jsonRequest = new JSONObject(jsonBody);
		JSONObject jsonResponse = new JSONObject();

		if (jsonBody == null) {
			jsonResponse.put("systemMessage", EndpointConstants.EMPTY_REQUEST);
			return Response.ok(jsonResponse.toString(), MediaType.APPLICATION_JSON).build();
		}
		
		String uuid = jsonRequest.getString("uuid");
		String major = jsonRequest.getString("major");
		String minor = jsonRequest.getString("minor");
		
    	Beacon beacon = new Beacon(uuid, major, minor);
    	beacon = beaconService.findByFilter(beacon).get(0);
    	//appService.notifyEntryInBeaconArea(beacon, request.userCode);
    	
    	//TODO: implement logic here
    	throw new UnsupportedOperationException("Not yet implemented");
    }

}
