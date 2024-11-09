package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatsIsValidRule;

@Service
public class CityIdFormatsIsValidRuleImpl implements CityIdFormatsIsValidRule {
	
	private MessageCatalogService messageCatalogService;
	
	
	
	public CityIdFormatsIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}



	@Override
	public void execute(UUID data) {
		if (UUIDHelper.isDefault(data)) {
			throw CityIdFormatIsNotValidException.create(messageCatalogService);
		}

	}




}
