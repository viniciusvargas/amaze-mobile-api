package mobi.inspire.amaze.services;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class MongoClientProvider {
	 private MongoClient mongoClient = null;

	    synchronized public void init() throws UnknownHostException {
	        if (mongoClient == null) {
	            mongoClient = new MongoClient("localhost");
	        }
	    }

	    public MongoClient get() {
	        try {
	            init();
	        } catch (UnknownHostException e) {
	            throw new RuntimeException(e);
	        }
	        return mongoClient;
	    }

}
