package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class ControllerUcoBetException extends UcoBetException{
	
	private static final long serialVersionUID = 1L;

	public ControllerUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.CONTROLLER, rootException);
	}
	
	public static final ControllerUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new ControllerUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final ControllerUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new ControllerUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final ControllerUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new ControllerUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final ControllerUcoBetException create(final  String userMessage) {
		
		return new ControllerUcoBetException(userMessage,userMessage, new Exception());
		
	}

	


}
