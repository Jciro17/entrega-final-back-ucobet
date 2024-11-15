package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;

public class CityIsUsedException extends RuleUcoBetException {
	
	private static final long serialVersionUID = 1L;

	public CityIsUsedException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityIsUsedException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIsUsedException");
		return new CityIsUsedException(userMessage, userMessage, new Exception());
	}

}
