package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.RegisterNewCityDtoMapper;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterNewCityInteractorImlp implements RegisterNewCityInteractor{
	
	private RegisterNewCity registerNewCityUseCase;
	
	public RegisterNewCityInteractorImlp(final RegisterNewCity registerNewCityUseCase) {
		this.registerNewCityUseCase=registerNewCityUseCase;
	}

	@Override
	public void execute(RegisterNewCityDto data) {
		
		var cityDomain = RegisterNewCityDtoMapper.INSTANCE.toDomain(data);
		
		
		registerNewCityUseCase.execute(cityDomain);
		
	}

}
