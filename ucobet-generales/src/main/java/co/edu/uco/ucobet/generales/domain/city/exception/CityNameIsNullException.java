package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;

public class CityNameIsNullException extends RuleUcoBetException{
	
	private static final long serialVersionUID = 1L;

	public CityNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityNameIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameIsEmptyExcpetion");
		return new CityNameIsNullException(userMessage, userMessage, new Exception());
	}

}
