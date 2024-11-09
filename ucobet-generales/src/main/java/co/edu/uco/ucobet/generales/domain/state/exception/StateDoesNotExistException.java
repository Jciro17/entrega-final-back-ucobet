package co.edu.uco.ucobet.generales.domain.state.exception;


import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;


public class StateDoesNotExistException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public StateDoesNotExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}

	public static final StateDoesNotExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("StateDoesNotExistException");
		return new StateDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
