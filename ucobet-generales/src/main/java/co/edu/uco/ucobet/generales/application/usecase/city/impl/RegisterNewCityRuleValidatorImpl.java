package co.edu.uco.ucobet.generales.application.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRuleValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.ValidateRulesRelatedWithId;
import co.edu.uco.ucobet.generales.application.usecase.city.ValidateRulesRelatedWithName;
import co.edu.uco.ucobet.generales.application.usecase.city.ValidateRulesRelatedWithState;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;

@Service
public final class RegisterNewCityRuleValidatorImpl implements RegisterNewCityRuleValidator {

	private ValidateRulesRelatedWithState validateRulesRelatedWithState;
	private ValidateRulesRelatedWithName validateRulesRelatedWithName;
	private ValidateRulesRelatedWithId validateRulesRelatedWithId;
	private CityIdDoesNotExistRule cityIdDoesNotExistRule;
	
	

	public RegisterNewCityRuleValidatorImpl(ValidateRulesRelatedWithState validateRulesRelatedWithState,
			ValidateRulesRelatedWithName validateRulesRelatedWithName,
			ValidateRulesRelatedWithId validateRulesRelatedWithId, CityIdDoesNotExistRule cityIdDoesNotExistRule) {
		this.validateRulesRelatedWithState = validateRulesRelatedWithState;
		this.validateRulesRelatedWithName = validateRulesRelatedWithName;
		this.validateRulesRelatedWithId = validateRulesRelatedWithId;
		this.cityIdDoesNotExistRule = cityIdDoesNotExistRule;
	}



	@Override
	public void validate(CityDomain data) {

		data.generateId();
		try {
			cityIdDoesNotExistRule.execute(data.getId());
		} catch (CityIdDoesExistsException exception) {
			validate(data);
		}

		validateRulesRelatedWithId.validate(data.getId());
		validateRulesRelatedWithName.validate(data);
		validateRulesRelatedWithState.validate(data.getState());
		

	}



}
