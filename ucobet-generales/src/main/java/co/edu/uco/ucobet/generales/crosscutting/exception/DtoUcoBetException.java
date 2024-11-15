package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class DtoUcoBetException extends UcoBetException{
	
	private static final long serialVersionUID = 1L;

	public DtoUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.DTO, rootException);
	}
	
	public static final DtoUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new DtoUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final DtoUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new DtoUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final DtoUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new DtoUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final DtoUcoBetException create(final  String userMessage) {
		
		return new DtoUcoBetException(userMessage,userMessage, new Exception());
	}

}
