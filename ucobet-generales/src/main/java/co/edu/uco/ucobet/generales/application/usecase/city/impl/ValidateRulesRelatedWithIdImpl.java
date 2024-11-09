package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.ValidateRulesRelatedWithId;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatsIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;

@Service
public class ValidateRulesRelatedWithIdImpl implements ValidateRulesRelatedWithId{
	
	
	private CityIdDoesNotExistRule cityIdDoesNotExistRule;
	private CityIdFormatsIsValidRule cityIdFormatIsValidRule;
	private CityIdIsNotEmptyRule cityIdIsNotEmptyRule;
	private CityIdIsNotNullRule cityIdIsNotNullRule;
	
	

	public ValidateRulesRelatedWithIdImpl(CityIdDoesNotExistRule cityIdDoesNotExistRule,
			CityIdFormatsIsValidRule cityIdFormatIsValidRule, CityIdIsNotEmptyRule cityIdIsNotEmptyRule,
			CityIdIsNotNullRule cityIdIsNotNullRule) {
		this.cityIdDoesNotExistRule = cityIdDoesNotExistRule;
		this.cityIdFormatIsValidRule = cityIdFormatIsValidRule;
		this.cityIdIsNotEmptyRule = cityIdIsNotEmptyRule;
		this.cityIdIsNotNullRule = cityIdIsNotNullRule;
	}



	@Override
	public void validate(UUID data) {
		cityIdDoesNotExistRule.execute(data);
		cityIdFormatIsValidRule.execute(data);
		cityIdIsNotEmptyRule.execute(data);
		cityIdIsNotNullRule.execute(data);
		
	}

}
