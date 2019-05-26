package pl.codecouple.graceful.shutdown;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class TomcatWithGracefulShutdown implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    private final TomcatGracefulShutdownConnector gracefulShutdown;

    public TomcatWithGracefulShutdown(final TomcatGracefulShutdownConnector gracefulShutdown) {
        this.gracefulShutdown = gracefulShutdown;
    }

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(gracefulShutdown);
    }

}