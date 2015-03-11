package mobi.inspire.amaze.services;

import java.net.UnknownHostException;

import mobi.inspire.amaze.model.Beacon;

public class BeaconService extends BaseService<Beacon>{
	
	EstablishmentService establishmentService = null;
	
	private static String COLLECTION_NAME = "beacons";
	
	public BeaconService() throws UnknownHostException {
		super(COLLECTION_NAME);
	}
	
	
}