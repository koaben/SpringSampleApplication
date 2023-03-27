package nl.aben.crud.demo.service;

import nl.aben.crud.demo.model.Politician;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactivePoliticianService {

    Flux<?> findAll();

    Mono<Politician> findById(int id);

    Mono<Politician> save(Politician politician);

    Mono<Politician> update(int id, Politician politician);

    Mono<Void> delete(int id);
}
