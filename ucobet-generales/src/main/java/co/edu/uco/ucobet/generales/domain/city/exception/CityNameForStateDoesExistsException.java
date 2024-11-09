package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;

public class CityNameForStateDoesExistsException extends RuleUcoBetException{
	
	private static final long serialVersionUID = 1L;

	public CityNameForStateDoesExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}

	public static final CityNameForStateDoesExistsException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameForStateDoesExistsException");
		return new CityNameForStateDoesExistsException(userMessage, userMessage, new Exception());
	}

}
