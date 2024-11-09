package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;


@Service
public class CityNameIsNotEmptyRuleImpl implements CityNameIsNotEmptyRule {
	private MessageCatalogService messageCatalogService;

	public CityNameIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void execute(String data) {
		if (TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyException.create(messageCatalogService);
		}

	}
}
