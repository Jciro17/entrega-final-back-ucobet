package co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller.response;

import java.util.ArrayList;

public class SendEmailResponse extends Response<String> {

    public SendEmailResponse() {
        setMensajes(new ArrayList<>());
        setDatos(null);
    }

}
