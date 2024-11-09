package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;

public class CityIdDoesExistsException extends RuleUcoBetException{
	
	private static final long serialVersionUID = 1L;

	

	public CityIdDoesExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	
	public static final CityIdDoesExistsException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdDoesExistsException");
		return new CityIdDoesExistsException(userMessage,userMessage,new Exception());
		
	}

}