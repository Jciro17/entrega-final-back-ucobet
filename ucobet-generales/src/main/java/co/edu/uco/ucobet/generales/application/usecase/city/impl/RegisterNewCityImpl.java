package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.info.EmailMessage;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.notificationservice.SendGridService;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.servicevault.ServiceVault;
import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRuleValidator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

    private final CityRepository cityRepository;
    private final RegisterNewCityRuleValidator registerNewCityRuleValidator;
    private final SendGridService sendGridService;
    private final MessageCatalogService messageCatalogService;
    private  final ServiceVault serviceVault;
    private final TelemetryService telemetryService;

    

    public RegisterNewCityImpl(CityRepository cityRepository, RegisterNewCityRuleValidator registerNewCityRuleValidator,
			SendGridService sendGridService, MessageCatalogService messageCatalogService,
			ServiceVault serviceVault, TelemetryService telemetryService) {
		super();
		this.cityRepository = cityRepository;
		this.registerNewCityRuleValidator = registerNewCityRuleValidator;
		this.sendGridService = sendGridService;
		this.messageCatalogService = messageCatalogService;
		this.serviceVault = serviceVault;
		this.telemetryService = telemetryService;
	}

	@Override
    public void execute(final CityDomain data) {
        registerNewCityRuleValidator.validate(data);

        var id = generarIdentificadorCiudad();

        var cityEntity = CityEntity.create().setId(id).setName(data.getName())
                                   .setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));

        cityRepository.save(cityEntity);
        
        Map<String, String> saveEventProps = new HashMap<>();
        saveEventProps.put(messageCatalogService.getMessage("CityID"), cityEntity.getId().toString());
        saveEventProps.put(messageCatalogService.getMessage("CityName"), cityEntity.getName());
        telemetryService.trackEvent(messageCatalogService.getMessage("CityEvent"), saveEventProps);
        
        String subject = serviceVault.getSecretValue("sujeto");
        String cuerpo = serviceVault.getSecretValue("cuerpo");
        String toEmail = serviceVault.getSecretValue("correo");
        
        EmailMessage email = EmailMessage.create(toEmail, subject, cuerpo);
        
        sendGridService.send(email);
        
        
       
    }

    private UUID generarIdentificadorCiudad() {
        UUID id = UUIDHelper.generate();
        boolean existeId = true;

        while (existeId) {
            id = UUIDHelper.generate();
            var resultados = cityRepository.findById(id);
            existeId = !resultados.isEmpty();
        }
        return id;
    }
}