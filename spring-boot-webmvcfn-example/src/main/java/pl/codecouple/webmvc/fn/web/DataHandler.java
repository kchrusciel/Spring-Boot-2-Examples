package pl.codecouple.webmvc.fn.web;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;

@Component
public class DataHandler {

    private final DataService dataService;

    public DataHandler(DataService dataService) {
        this.dataService = dataService;
    }

    public ServerResponse handleGetAll(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(dataService.getAll());
    }

    public ServerResponse handleGetOne(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(dataService.getById(
                        Long.parseLong(
                                serverRequest.pathVariable("id"))));
    }

    public ServerResponse handlePost(ServerRequest serverRequest) throws ServletException, IOException {
        dataService.save(serverRequest.body(String.class));
        return ServerResponse.created(URI.create("/location")).build();
    }

}