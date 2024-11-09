package co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.servicevault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

import co.edu.uco.ucobet.generales.application.secondaryports.servicevault.ServiceVault;


@Component
public class ServiceVaultImpl implements ServiceVault {

    private final SecretClient secretClient;

    public ServiceVaultImpl(@Value("${azure.keyvault.url}") String urlVault){
        this.secretClient = new SecretClientBuilder().vaultUrl(urlVault)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

	@Override
	public String getSecretValue(String secretName) {
        return secretClient.getSecret(secretName).getValue();

	}


}
