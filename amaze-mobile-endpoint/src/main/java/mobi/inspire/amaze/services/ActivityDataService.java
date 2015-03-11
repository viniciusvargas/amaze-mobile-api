package mobi.inspire.amaze.services;

import java.net.UnknownHostException;

import mobi.inspire.amaze.model.ActivityData;

public class ActivityDataService extends BaseService<ActivityData>{

	private static String COLLECTION_NAME = "templates";
	
	public ActivityDataService() throws UnknownHostException {
		super(COLLECTION_NAME);
	}
	
}
