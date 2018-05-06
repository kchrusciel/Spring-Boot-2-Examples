package pl.codecouple.springbootwebfluxexample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

/**
 * Created by CodeCouple.pl
 */
@RestController
class Controller {

    @GetMapping
    Mono<String> helloCodeCouple() {
        return Mono.just("Hello Code Couple!");
    }

    @GetMapping("flux")
    Flux<String> helloCodeCoupleFlux() {
        return Flux.fromStream(Stream.of("Hello", "Code", "Couple"));
    }

}
