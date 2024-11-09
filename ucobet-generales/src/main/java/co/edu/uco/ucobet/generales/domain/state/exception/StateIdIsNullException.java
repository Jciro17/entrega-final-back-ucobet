package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcoBetException;

public class StateIdIsNullException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public StateIdIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}

	public static final StateIdIsNullException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("StateIdIsNullException");
		return new StateIdIsNullException(userMessage, userMessage, new Exception());
	}

}
