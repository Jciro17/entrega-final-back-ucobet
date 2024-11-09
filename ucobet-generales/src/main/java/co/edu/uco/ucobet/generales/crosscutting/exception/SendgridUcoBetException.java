package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class SendgridUcoBetException extends UcoBetException{
	
    private static final long serialVersionUID = 1L;

    public SendgridUcoBetException(final String userMessage, final String technicalMessage,
                               final Exception rootException) {
        super(userMessage, technicalMessage, Layer.EMAIL, rootException);
    }

    public static SendgridUcoBetException create (final String userMessage, final String technicalMessage,
                                              final Exception rootException) {
        return new SendgridUcoBetException(userMessage, technicalMessage, rootException);
    }

    public static SendgridUcoBetException create (final String userMessage, final String technicalMessage){
        return new SendgridUcoBetException(userMessage, technicalMessage, new Exception());
    }

    public static SendgridUcoBetException create (final String userMessage){
        return new SendgridUcoBetException(userMessage, userMessage, new Exception());
    }

}
