package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;

@Service
public class CityIdDoesNotExistsRuleImpl implements CityIdDoesNotExistRule{
	
	private CityRepository cityRepository;

	private MessageCatalogService messageCatalogService;

	public CityIdDoesNotExistsRuleImpl(CityRepository cityRepository, MessageCatalogService messageCatalogService) {
		this.cityRepository = cityRepository;
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void execute(UUID data) {
		if (cityRepository.existsById(data)) {
			throw CityIdDoesExistsException.create(messageCatalogService);
		}

	}

}
