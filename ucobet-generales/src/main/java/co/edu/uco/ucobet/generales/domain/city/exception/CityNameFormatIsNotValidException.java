package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;

public class CityNameFormatIsNotValidException extends RuleUcoBetException{
	
	private static final long serialVersionUID = 1L;

	public CityNameFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityNameFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameFormatIsNotValidException");
		return new CityNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
