package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class DomainUcoBetException extends UcoBetException{
	
	private static final long serialVersionUID = 1L;

	public DomainUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.DOMAIN, rootException);
	}
	
	public static final DomainUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new DomainUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final DomainUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new DomainUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final DomainUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new DomainUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final DomainUcoBetException create(final  String userMessage) {
		
		return new DomainUcoBetException(userMessage,userMessage, new Exception());
		
	}
	

}
