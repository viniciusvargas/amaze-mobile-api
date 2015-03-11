package mobi.inspire.amaze.dataloaders;

import java.util.HashMap;
import java.util.Map;

import mobi.inspire.amaze.model.ActivityData;

public class ActivityDataDataLoader {
	
	public static void main(String... args) {
		ActivityData activityData = new ActivityData();
		Map<String,String> actions = new HashMap<String,String>();
		actions.put("action1", "/actions/action1");
		actions.put("action2", "/actions/action2");
		
		Map<String,String> images = new HashMap<String,String>();
		images.put("image1", "/images/image001.jpg");
		images.put("image2", "/images/image002.jpg");
		
		Map<String,String> texts = new HashMap<String,String>();
		texts.put("region1", "lorem ipsum dolor sit amet");
		texts.put("region2", "lorem ipsum dolor sit amet");
		texts.put("region3", "lorem ipsum dolor sit amet");
		
		activityData.actions = actions;
		activityData.texts = texts;
		activityData.images = images;
		activityData.templateCode = "TEMPLATE_01";
		
	}

}