package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class CrosscutingUcoBetException extends UcoBetException{
	
	private static final long serialVersionUID = 1L;

	public CrosscutingUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.CROSSCUTTING, rootException);
	}
	
	
	public static  CrosscutingUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new CrosscutingUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static  CrosscutingUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new CrosscutingUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static  CrosscutingUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new CrosscutingUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static  CrosscutingUcoBetException create(final  String userMessage) {
		
		return new CrosscutingUcoBetException(userMessage,userMessage, new Exception());
		
	}
	


	
	

}
