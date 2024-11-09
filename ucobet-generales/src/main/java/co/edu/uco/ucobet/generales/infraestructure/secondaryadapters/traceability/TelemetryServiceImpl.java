package co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.traceability;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.microsoft.applicationinsights.TelemetryClient;

import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;

@Component
public class TelemetryServiceImpl implements TelemetryService {

    private final TelemetryClient telemetryClient;

    public TelemetryServiceImpl(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    @Override
    public void trackEvent(String eventName) {
    	telemetryClient.trackEvent("Telemetry Initialized");
    }

    @Override
    public void trackEvent(String eventName, Map<String, String> properties) {
        telemetryClient.trackEvent(eventName, properties, null);
    }

    @Override
    public void trackMetric(String metricName, double value) {
        telemetryClient.trackMetric(metricName, value);
    }

    @Override
    public void trackException(Exception exception) {
        telemetryClient.trackException(exception);
    }
    
    
}
