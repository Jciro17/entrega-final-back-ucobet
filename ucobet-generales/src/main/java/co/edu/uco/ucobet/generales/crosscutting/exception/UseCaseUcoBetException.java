package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class UseCaseUcoBetException extends UcoBetException {
	
	private static final long serialVersionUID = 1L;

	public UseCaseUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.USERCASE, rootException);
	}
	
	public static final UseCaseUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new UseCaseUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final UseCaseUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new UseCaseUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final UseCaseUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new UseCaseUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final UseCaseUcoBetException create(final  String userMessage) {
		
		return new UseCaseUcoBetException(userMessage,userMessage, new Exception());
		
	}
	
	

}
