package mobi.inspire.amaze.endpoints.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;

public class ActionRequest {
	
	@Expose
	public String authToken;
	
	@Expose
	public List<String> parameters;
	
	@Expose
	public Map<String,String> additionalData;

}
