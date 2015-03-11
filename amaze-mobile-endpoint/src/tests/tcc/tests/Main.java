package tcc.tests;

import mobi.inspire.amaze.endpoints.model.FindBeaconResponse;
import mobi.inspire.amaze.model.ActivityData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		
		FindBeaconResponse response = new FindBeaconResponse();
		ActivityData template = new ActivityData();
		response.template = template;
		
		String json = gson.toJson(response);
		
		System.out.println(json);
	}

}
