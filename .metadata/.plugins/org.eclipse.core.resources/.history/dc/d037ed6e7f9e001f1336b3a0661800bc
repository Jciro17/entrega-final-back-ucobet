package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.exception.StateDoesNotExistException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

@Service
public class StateDoesExistRuleImpl implements StateDoesExistRule {
	private StateRepository stateRepository;

	private MessageCatalogServiceImpl messageCatalogService;
	
	public StateDoesExistRuleImpl(StateRepository stateRepository,MessageCatalogServiceImpl messageCatalogService) {
		this.stateRepository = stateRepository;
		this.messageCatalogService=messageCatalogService;
	}

	@Override
	public void execute(UUID data) {

		if (!stateRepository.existsById(data)) {
			throw StateDoesNotExistException.create(messageCatalogService);
		}

	}

}