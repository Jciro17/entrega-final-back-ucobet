package co.edu.uco.ucobet.generales.application.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.ValidateRulesRelatedWithState;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public class ValidateRulesRelatedWithStateImpl implements ValidateRulesRelatedWithState {
	
	private StateDoesExistRule stateDoesExistRule;
	private StateIdIsNotNullRule stateIdIsNotNullRule;
	
	

	public ValidateRulesRelatedWithStateImpl(StateDoesExistRule stateDoesExistRule , StateIdIsNotNullRule stateIdIsNotNullRule) {
		this.stateDoesExistRule = stateDoesExistRule;
		this.stateIdIsNotNullRule= stateIdIsNotNullRule;
		
	}



	@Override
	public void validate(StateDomain data) {
		stateIdIsNotNullRule.execute(data);
		stateDoesExistRule.execute(data.getId());

		
	}

}
