package pl.codecouple.routerfunctions.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by CodeCouple.pl
 */
@Component
class ReactiveHandler {

    Mono<ServerResponse> get(ServerRequest request) {
        Mono<String> slogan = Mono.just("CodeCouple roxx!");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(slogan, String.class);
    }

    Mono<ServerResponse> post(ServerRequest request) {
        Mono<String> value = request.bodyToMono(String.class);
        //do something with value
        return ServerResponse.created(URI.create("/code-couple/1")).body(value, String.class);
    }

}