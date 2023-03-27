package nl.aben.crud.demo.handler;


import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.service.ReactivePoliticianService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ReactivePoliticianHandler {

    private final ReactivePoliticianService reactivePoliticianService;


    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        Flux<?> list = reactivePoliticianService.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(list, Politician.class);
    }


    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Politician> politicianMono = reactivePoliticianService.findById(id);
        return ServerResponse.ok().body(politicianMono, Politician.class);
    }


    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<Politician> politician = serverRequest.bodyToMono(Politician.class);
        Mono<Politician> politicianMono = reactivePoliticianService.save(politician.block());
        return ServerResponse.ok().body(politicianMono, Politician.class);
    }


    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Politician> politician = serverRequest.bodyToMono(Politician.class);
        Mono<Politician> politicianMono = reactivePoliticianService.update(id, politician.block());
        return ServerResponse.ok().body(politicianMono, Politician.class);
    }


    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Mono<Void> politicianMono = reactivePoliticianService.delete(id);
        return ServerResponse.ok().body("Deleted successfully...!", String.class);
    }

}
