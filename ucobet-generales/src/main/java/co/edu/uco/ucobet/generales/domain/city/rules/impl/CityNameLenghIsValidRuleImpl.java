package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameLenghIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghIsValidRule;

@Service
public class CityNameLenghIsValidRuleImpl implements CityNameLenghIsValidRule {
	
	private MessageCatalogService messageCatalogService;
	
	
	
	public CityNameLenghIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	private static final int MIN_NAME_LENGTH = 5;
	private static final int MAX_NAME_LENGTH = 40;

	@Override
	public void execute(String data) {
		if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			throw CityNameLenghIsNotValidException.create(messageCatalogService);
		
	}
	}
}
