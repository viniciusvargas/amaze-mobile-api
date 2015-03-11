package mobi.inspire.amaze.endpoints;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import mobi.inspire.amaze.endpoints.model.FindBeaconRequest;
import mobi.inspire.amaze.model.Beacon;
import mobi.inspire.amaze.services.ProximityService;
import mobi.inspire.amaze.services.BeaconService;

public class ProximityEndpoint extends BaseEndpoint{
	
	BeaconService beaconService = null;
	ProximityService appService = null;
	
	public ProximityEndpoint() throws UnknownHostException{
		super();
		beaconService = new BeaconService();
		appService = new ProximityService();
	}
	
	@GET
    @Path("/notify_exit")
    @Produces("application/json")
    public Response notifyExitFromBeaconArea(String jsonBody) {
    	FindBeaconRequest request = gson.fromJson(jsonBody, FindBeaconRequest.class);
    	Beacon beacon = new Beacon(request.uuid, request.major, request.minor);
    	beacon = beaconService.query(beacon).get(0);
    	appService.notifyExitFromBeaconArea(beacon, request.userCode);
    	
    	//TODO: implement logic here
    	throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @GET
    @Path("/notify_exit")
    @Produces("application/json")
    public Response notifyEntryInBeaconArea(String jsonBody) {
    	FindBeaconRequest request = gson.fromJson(jsonBody, FindBeaconRequest.class);
    	Beacon beacon = new Beacon(request.uuid, request.major, request.minor);
    	beacon = beaconService.query(beacon).get(0);
    	appService.notifyEntryInBeaconArea(beacon, request.userCode);
    	
    	//TODO: implement logic here
    	throw new UnsupportedOperationException("Not yet implemented");
    }

}
