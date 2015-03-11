package mobi.inspire.amaze.endpoints.model;

import mobi.inspire.amaze.model.ActivityData;

import com.google.gson.annotations.Expose;

public class FindBeaconResponse extends BaseResponse{
	
	@Expose
	public String authToken;
	
	@Expose
	public ActivityData activity;

}
