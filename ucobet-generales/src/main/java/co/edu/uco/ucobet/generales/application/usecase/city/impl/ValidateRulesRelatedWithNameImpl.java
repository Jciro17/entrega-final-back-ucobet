package co.edu.uco.ucobet.generales.application.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.ValidateRulesRelatedWithName;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghIsValidRule;

@Service
public class ValidateRulesRelatedWithNameImpl implements ValidateRulesRelatedWithName{
	
	
	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	
	private CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistsRule;
	
	private CityNameIsNotEmptyRule cityNameIsNotEmpyRule;
	
	private CityNameIsNotNullRule cityNameIsNotNullRule;

	private CityNameLenghIsValidRule cityNameLenghIsValidRule;
	
	

	public ValidateRulesRelatedWithNameImpl(CityNameFormatIsValidRule cityNameFormatIsValidRule,
			CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistsRule,
			CityNameIsNotEmptyRule cityNameIsNotEmpyRule, CityNameIsNotNullRule cityNameIsNotNullRule,
			CityNameLenghIsValidRule cityNameLenghIsValidRule) {
		this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
		this.cityNameForStateDoesNotExistsRule = cityNameForStateDoesNotExistsRule;
		this.cityNameIsNotEmpyRule = cityNameIsNotEmpyRule;
		this.cityNameIsNotNullRule = cityNameIsNotNullRule;
		this.cityNameLenghIsValidRule = cityNameLenghIsValidRule;
	}



	@Override
	public void validate(CityDomain data) {
		cityNameIsNotEmpyRule.execute(data.getName());
		cityNameIsNotNullRule.execute(data.getName());
		cityNameFormatIsValidRule.execute(data.getName());
		cityNameLenghIsValidRule.execute(data.getName());
		cityNameForStateDoesNotExistsRule.execute(data);
		
	}

}
