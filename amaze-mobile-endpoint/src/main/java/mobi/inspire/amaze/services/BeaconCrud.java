package mobi.inspire.amaze.services;

import java.net.UnknownHostException;

import com.google.gson.Gson;

import mobi.inspire.amaze.model.Beacon;
import mobi.inspire.amaze.model.Establishment;

public class BeaconCrud {
	
	public static void main(String[] args) throws UnknownHostException {
		Gson gson = new Gson();
		
		BeaconService beaconService = new BeaconService();
		EstablishmentService establishmentService = new EstablishmentService();
		
		String uuid = "566C5595-6EC7-4F08-909F-C954BDCA6CD3";
		String major = "1";
		String minor = "1";
		
		Beacon beacon = new Beacon(uuid, major, minor);
		Establishment establishment = new Establishment();
		establishment.code = "CAR";
		establishment.name = "Carrefour";
		
		establishment = establishmentService.save(establishment);
		
		beacon.establishment_id = establishment._id;
		beaconService.save(beacon);
		
		Beacon newBeacon = beaconService.query(beacon).get(0);
		
		System.out.println(gson.toJson(newBeacon));
	}

}