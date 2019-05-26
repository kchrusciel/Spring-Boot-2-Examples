package pl.codecouple.webmvc.fn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import pl.codecouple.webmvc.fn.web.DataHandler;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(DataHandler dataHandler) {
        return route()
                .GET("/code-couple", dataHandler::handleGetAll)
                .GET("/code-couple/{id}", dataHandler::handleGetOne)
                .POST("/code-couple", dataHandler::handlePost)
                .build();
    }

}