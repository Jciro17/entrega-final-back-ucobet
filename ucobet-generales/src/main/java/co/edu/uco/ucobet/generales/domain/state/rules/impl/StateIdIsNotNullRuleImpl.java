package co.edu.uco.ucobet.generales.domain.state.rules.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.domain.state.exception.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule{
	
	private MessageCatalogService messageCatalogService;
	
	
	
	public StateIdIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}



	@Override
	public void execute(StateDomain data) {
		
		if(ObjectHelper.isNull(data)) {
			throw StateIdIsNullException.create(messageCatalogService);
		}
		
	}



}
