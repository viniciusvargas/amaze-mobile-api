package tcc.tests;

import static org.easymock.EasyMock.createNiceMock;
import mobi.inspire.amaze.endpoints.model.FindBeaconRequest;
import mobi.inspire.amaze.model.ActivityData;
import mobi.inspire.amaze.services.ProximityService;

import org.junit.Before;
import org.junit.Test;

public class AppServiceTest {

	private ProximityService appService = null;
	private ActivityData template = null;
	private FindBeaconRequest request = null;
	
	@Before
	public void setUp() {
		request = createNiceMock(FindBeaconRequest.class);
		template = createNiceMock(ActivityData.class);
		appService = new ProximityService();
	}
	
	@Test
	public void testValidateAppVersionAndTemplateRequested() {
		
	}

}