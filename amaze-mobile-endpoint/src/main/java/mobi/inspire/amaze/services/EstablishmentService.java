package mobi.inspire.amaze.services;

import java.net.UnknownHostException;

import org.mongodb.morphia.query.Query;

import com.google.gson.Gson;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import mobi.inspire.amaze.model.Beacon;
import mobi.inspire.amaze.model.Establishment;

public class EstablishmentService extends BaseService<Establishment>{

	private static String COLLECTION_NAME = "establishments";
	
	public EstablishmentService() throws UnknownHostException {
		super(COLLECTION_NAME);
	}
	
}
