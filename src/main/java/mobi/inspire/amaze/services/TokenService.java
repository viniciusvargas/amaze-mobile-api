package mobi.inspire.amaze.services;

import mobi.inspire.amaze.endpoints.model.Token;
import mobi.inspiring.amaze.core.service.GenericService;

public class TokenService extends GenericService<Token, Integer>{
	
	public TokenService() {
		super(Token.class);
	}

}
