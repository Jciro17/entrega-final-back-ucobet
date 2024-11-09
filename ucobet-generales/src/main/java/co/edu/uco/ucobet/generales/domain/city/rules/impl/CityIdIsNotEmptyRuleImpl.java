package co.edu.uco.ucobet.generales.domain.city.rules.impl;


import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;

@Service
public class CityIdIsNotEmptyRuleImpl  implements CityIdIsNotEmptyRule{

	private MessageCatalogService messageCatalogService;
	
	

	public CityIdIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		super();
		this.messageCatalogService = messageCatalogService;
	}



	@Override
	public final void execute(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsEmptyException.create(messageCatalogService);
		}
		
	}
}
