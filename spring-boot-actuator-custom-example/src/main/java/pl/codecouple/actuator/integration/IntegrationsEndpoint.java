package pl.codecouple.actuator.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

@Component
@WebEndpoint(id = "integrations", enableByDefault = false)
public class IntegrationsEndpoint {

	private Map<String, Integration> integrations = new HashMap<>();

	@ReadOperation
	public Map<String, Integration> getIntegrations() {
		return integrations;
	}

	@ReadOperation
	public Integration getIntegration(@Selector String name) {
		return integrations.get(name);
	}

	@WriteOperation
	public void addIntegration(@Selector String name, Integration integration) {
		integrations.put(name, integration);
	}

	@DeleteOperation
	public void deleteIntegrationBy(@Selector String name) {
		integrations.remove(name);
	}

}

class Integration {

	private String integration;

	public String getIntegration() {
		return integration;
	}

	public void setIntegration(final String integration) {
		this.integration = integration;
	}
}
