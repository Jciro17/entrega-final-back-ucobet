package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;


@Service
public class CityNameIsNotNullRuleImpl  implements CityNameIsNotNullRule{
 
	private MessageCatalogService messageCatalogService;
	
	

	public CityNameIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		super();
		this.messageCatalogService = messageCatalogService;
	}



	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw CityNameIsNullException.create(messageCatalogService);
		}
		
	}
}
