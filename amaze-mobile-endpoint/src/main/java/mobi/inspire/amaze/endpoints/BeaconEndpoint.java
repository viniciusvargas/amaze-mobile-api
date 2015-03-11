package mobi.inspire.amaze.endpoints;

import java.net.UnknownHostException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import mobi.inspire.amaze.endpoints.constants.EndpointConstants;
import mobi.inspire.amaze.endpoints.model.CreateBeaconRequest;
import mobi.inspire.amaze.endpoints.model.CreateBeaconResponse;
import mobi.inspire.amaze.endpoints.model.FindBeaconRequest;
import mobi.inspire.amaze.endpoints.model.FindBeaconResponse;
import mobi.inspire.amaze.model.ActivityData;
import mobi.inspire.amaze.model.Beacon;
import mobi.inspire.amaze.model.Establishment;
import mobi.inspire.amaze.services.ProximityService;
import mobi.inspire.amaze.services.BeaconService;
import mobi.inspire.amaze.services.EstablishmentService;
import mobi.inspire.amaze.services.ActivityDataService;
import mobi.inspire.amaze.services.TokenService;
import mobi.inspire.amaze.services.UserService;

public class BeaconEndpoint extends BaseEndpoint{

	BeaconService beaconService = null;
	ProximityService appService = null;
	UserService userService = null;
	ActivityDataService templateService = null;
	TokenService tokenService = null;
	EstablishmentService establishmentService = null;
	
	public BeaconEndpoint() throws UnknownHostException {
		beaconService = new BeaconService();
		tokenService = new TokenService();		
	}

    @POST
    @Path("/identify_beacon")
    @Produces("application/json")
    public Response identifyBeacon(String jsonBody) {
    	FindBeaconRequest request = gson.fromJson(jsonBody, FindBeaconRequest.class);
    	FindBeaconResponse responseBeacon = new FindBeaconResponse();
    	
    	Beacon beacon = new Beacon(request.uuid, request.major, request.minor);
    	beacon = beaconService.query(beacon).get(0);
    	
    	if (beacon != null) {
    		String token = tokenService.generateAuthToken(beacon, request.userCode);
    		ActivityData activityData = templateService.get(beacon.initialTemplate_id);
    		responseBeacon.template = template;
    		responseBeacon.authToken = token;
    		
    		if (template != null && request.appVersion < template.minimumVersion) {
        		responseBeacon.systemMessage = EndpointConstants.APP_VERSION_BELOW_MINIMUM_REQUIRED_FOR_BEACON_TEMPLATE;
        	}
    		
    	} else {
    		responseBeacon.systemMessage = EndpointConstants.BEACON_NOT_FOUND;
    	}

    	return Response.status(200).entity(responseBeacon).build();
    }
    
    @POST
    @Path("/save_beacon")
    @Produces("application/json")
    public Response createBeacon(String jsonBody) {
    	CreateBeaconRequest request = gson.fromJson(jsonBody, CreateBeaconRequest.class);
    	CreateBeaconResponse response = new CreateBeaconResponse();
    	Beacon beacon = new Beacon(request.uuid, request.major, request.minor);
    	Establishment establishment = establishmentService.get(request.establishmentCode);
    	
    	if (establishment != null) {
    		beacon.establishment_id = establishment._id;
    		beaconService.save(beacon);
    		response.status = true;
    	} else {
    		response.systemMessage = EndpointConstants.ESTABLISHMENT_NOT_FOUND;
    	}
    	
    	return Response.status(200).entity(response).build();
    }
    
}