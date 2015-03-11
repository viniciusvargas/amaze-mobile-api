package mobi.inspire.amaze.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

@Entity("beacons")
public class Beacon extends BaseEntity{
	
	public String uuid;
	public String major;
	public String minor;
	
	public String establishment_id;
	
	public String initialTemplate_id;
	
	public Beacon(String uuid, String major, String minor) {
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
	}
	
	public Beacon() {}
	
	public static Beacon buildFromAdvertisementData(String data) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	
}