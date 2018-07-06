package pl.codecouple.routerfunctions.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by CodeCouple.pl
 */
@Configuration
class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(ReactiveHandler handler) {
        return route(GET("/code-couple"), handler::get)
                .andRoute(POST("/code-couple"), handler::post);
    }

}
