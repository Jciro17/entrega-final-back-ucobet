package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;


@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule{

	private MessageCatalogService messageCatalogService;
	
	
	
	public CityNameFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	String format = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

    @Override
    public void execute(String data) {
        if (!data.matches(format)) {
            throw CityNameFormatIsNotValidException.create(messageCatalogService);
        }
    }
}
