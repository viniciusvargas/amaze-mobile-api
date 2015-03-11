package mobi.inspire.amaze.services;

import java.net.UnknownHostException;

import com.google.gson.Gson;

import mobi.inspire.amaze.model.User;

public class UserService extends BaseService<User>{
	
	private static String COLLECTION_NAME = "users";

	public UserService() throws UnknownHostException {
		super(COLLECTION_NAME);
	}

}
