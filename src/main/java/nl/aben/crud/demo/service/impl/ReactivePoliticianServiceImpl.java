package nl.aben.crud.demo.service.impl;

import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.repository.PoliticianRepository;
import nl.aben.crud.demo.service.ReactivePoliticianService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class ReactivePoliticianServiceImpl implements ReactivePoliticianService {

    @Autowired
    private PoliticianRepository repository;



    @Override
    public Flux<?> findAll() {

        List<Politician> politicians = repository.findAll();

        return Flux.fromIterable(politicians)
               // .delayElements(Duration.ofSeconds(1))
                .doOnNext(politician -> log.info("*** {}", politician))
                .map(politician -> politician)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<Politician> findById(int id) {

        Politician politician = repository.findById(id).orElseThrow(() -> new NotFoundException("** politician not found for id :: " + id));
        return Mono.just(politician)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<Politician> save(Politician politician) {

        politician = repository.save(politician);
        return Mono.just(politician)
                .log();     // log() to print event stream on console. Check console for event logs
    }

    @Override
    public Mono<Politician> update(int id, Politician politician) {

        repository.findById(id).orElseThrow(() -> new NotFoundException("** Politician not found for id :: " + id));
        politician.setId(id);
        return this.save(politician);
    }

    @Override
    public Mono<Void> delete(int id) {
        repository.findById(id).ifPresent(repository::delete);
        return Mono.empty();
    }
}
