package co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.application.primaryports.dto.state.ConsultStateDto;

public class StateResponse  extends Response<ConsultStateDto>{
	
	public StateResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}


}
