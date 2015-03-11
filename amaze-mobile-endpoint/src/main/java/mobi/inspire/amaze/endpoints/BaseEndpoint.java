package mobi.inspire.amaze.endpoints;

import com.google.gson.Gson;

public abstract class BaseEndpoint {
	protected Gson gson = null;
	public BaseEndpoint() {
		gson = new Gson();
	}
}
