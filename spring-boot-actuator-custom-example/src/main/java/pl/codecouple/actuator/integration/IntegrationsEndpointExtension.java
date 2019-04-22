package pl.codecouple.actuator.integration;

import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = IntegrationsEndpoint.class)
public class IntegrationsEndpointExtension {

	private final IntegrationsEndpoint endpoint;

	public IntegrationsEndpointExtension(final IntegrationsEndpoint endpoint) {
		this.endpoint = endpoint;
	}

	@ReadOperation
	WebEndpointResponse<Map<String, Integration>> integrations() {
		final Map<String, Integration> integrations = endpoint.getIntegrations();
		if (integrations.containsKey("someValue")) {
			return new WebEndpointResponse<>(
					integrations,
					HttpStatus.CONFLICT.value());
		}
		return new WebEndpointResponse<>(
				integrations,
				HttpStatus.I_AM_A_TEAPOT.value());
	}
}
