package mobi.inspire.amaze.model;

import java.util.Map;

import org.mongodb.morphia.annotations.Reference;

import com.google.gson.annotations.Expose;

public class ActivityData {

	@Expose
	public String activityCode;
	
	@Expose
	public String templateCode;
	
	@Expose
	public Map<String,String> images;
	
	@Expose
	public Map<String,String> texts;
	
	@Expose
	public Map<String,String> actions;
	
	public short minimumVersion;
	
	@Expose
	public Establishment establishment;
	
	
	public ActivityData(){}
}
