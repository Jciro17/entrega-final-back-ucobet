package co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;

public class CityResponse extends Response<RegisterNewCityDto> {

	public CityResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
