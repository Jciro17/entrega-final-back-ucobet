package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public class UcoBetException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private  final String userMessage;
	private  final Layer layer;
	
	public UcoBetException(String technicalMessage,
			String userMessage,Layer layer,
			Exception rootException) {
		
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)),ObjectHelper.getDefault(rootException, new Exception()));
		
		this.userMessage =TextHelper.applyTrim(userMessage);
		this.layer = layer;
	}

	public String getUserMessage() {
		return userMessage;
	}


	public Layer getLayer() {
		return layer;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public static  UcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new UcoBetException(technicalMessage, userMessage, Layer.GENERAL, rootException);
		
	}
	
	public static  UcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new UcoBetException(userMessage, userMessage, Layer.GENERAL, rootException);
		
	}
	
	public static  UcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new UcoBetException(technicalMessage, userMessage, Layer.GENERAL, new Exception());
		
	}
	
	public static UcoBetException create(final  String userMessage) {
		
		return new UcoBetException(userMessage,userMessage, Layer.GENERAL, new Exception());
		
	}
}
