package mobi.inspire.amaze.endpoints;

import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import mobi.inspire.amaze.endpoints.constants.EndpointConstants;
import mobi.inspire.amaze.services.TokenService;
import mobi.inspiring.amaze.core.model.Beacon;
import mobi.inspiring.amaze.core.service.BeaconService;
import mobi.inspiring.amaze.core.service.EstablishmentService;

@Singleton
@Path("/beacon")
public class BeaconEndpoint extends BaseEndpoint {

	BeaconService beaconService;
	TokenService tokenService;
	EstablishmentService establishmentService;

	public BeaconEndpoint() throws UnknownHostException {
		beaconService = new BeaconService();
		tokenService = new TokenService();
		establishmentService = new EstablishmentService();
	}

	@POST
	@Path("/identify")
	@Produces(MediaType.APPLICATION_JSON)
	public Response identifyBeacon(String jsonBody) {
		
		JSONObject jsonResponse = new JSONObject();

		if (jsonBody == null) {
			jsonResponse.put("systemMessage", EndpointConstants.EMPTY_REQUEST);
			return Response.ok(jsonResponse.toString(), MediaType.APPLICATION_JSON).build();
		}
		
		JSONObject jsonRequest = new JSONObject(jsonBody);
		
		String uuid = jsonRequest.getString("uuid");
		String major = jsonRequest.getString("major");
		String minor = jsonRequest.getString("minor");

		Beacon beacon = new Beacon(uuid, major, minor);
		List<Beacon> listBeacon = beaconService.findByFilter(beacon); 

		if (listBeacon == null || listBeacon.size() == 0) {
			jsonResponse.put("systemMessage", EndpointConstants.BEACON_NOT_FOUND);
			return Response.ok(jsonResponse.toString(), MediaType.APPLICATION_JSON).build();
		}
		
		beacon = listBeacon.get(0);
		
		//check if beacon have any details linked to it
		if (beacon.getBeaconDetails() != null) {
			JSONObject beaconDetailsJsonObject = new JSONObject();
			beaconDetailsJsonObject.put("text", beacon.getBeaconDetails().getText());
			beaconDetailsJsonObject.put("imageUrl", beacon.getBeaconDetails().getImageUrl());
			jsonResponse.put("beaconDetails", beaconDetailsJsonObject);
		}

		return Response.ok(jsonResponse.toString(), MediaType.APPLICATION_JSON).build();
	}

}
