package co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller.city;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller.response.CityResponse;
import co.edu.uco.ucobet.generales.crosscutting.helpers.SanitizerHelper;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;

@RestController
@RequestMapping("/generales/api/v1/cities")
public class RegisterNewCityController {

    private final RegisterNewCityInteractor registerNewCityInteractor;
    private final MessageCatalogService messageCatalogService;
    private final TelemetryService telemetryService;
    private final SanitizerHelper sanitizerHelper;

    public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor,
                                     MessageCatalogService messageCatalogService,
                                     TelemetryService telemetryService,
                                     SanitizerHelper sanitizerHelper) {
        this.registerNewCityInteractor = registerNewCityInteractor;
        this.messageCatalogService = messageCatalogService;
        this.telemetryService = telemetryService;
        this.sanitizerHelper = sanitizerHelper;
    }

    @GetMapping
    public RegisterNewCityDto getDummy() {
        return RegisterNewCityDto.create("rionegro", UUIDHelper.getDefault());
    }

    @PostMapping
    public ResponseEntity<CityResponse> crear(@RequestBody RegisterNewCityDto city) {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var ciudadResponse = new CityResponse();
        Map<String, String> properties = new HashMap<>();

        city.setName(sanitizerHelper.sanitizeInput(city.getName()));
        properties.put("cityName", city.getName());

        try {
            registerNewCityInteractor.execute(city);
            ciudadResponse.getMensajes().add(messageCatalogService.getMessage("ciudadExitosa"));

            telemetryService.trackEvent("CityCreatedSuccessfully", properties);

        } catch (final UcoBetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            ciudadResponse.getMensajes().add(excepcion.getUserMessage());

            telemetryService.trackEvent("CityCreationFailed", properties);
            telemetryService.trackException(excepcion);

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = messageCatalogService.getMessage("errorCiudad");
            ciudadResponse.getMensajes().add(mensajeUsuario);

            telemetryService.trackEvent("CityCreationFailed", properties);
            telemetryService.trackException(excepcion);
        }

        return new ResponseEntity<>(ciudadResponse, httpStatusCode);
    }
}
