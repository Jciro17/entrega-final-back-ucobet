package co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.traceability.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;

@Configuration
public class ApplicationInsightsConfig {

    @Bean
    public TelemetryClient telemetryClient() {
        String instrumentationKey = System.getenv("APPLICATION_INSIGHTS_INSTRUMENTATION_KEY");
        if (instrumentationKey == null) {
            instrumentationKey = "a8905d76-faed-43b7-9f81-882bf8e5af28"; // Reemplaza con la clave o utiliza Azure Key Vault
        }
        TelemetryConfiguration configuration = TelemetryConfiguration.getActive();
        configuration.setInstrumentationKey(instrumentationKey);
        return new TelemetryClient(configuration);
    }
}
