package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;

public class CityIdDoesNotExistsException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	private CityIdDoesNotExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityIdDoesNotExistsException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdDoesNotExistsException");
		return new CityIdDoesNotExistsException(userMessage, userMessage, new Exception());
	}

}
