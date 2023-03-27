package nl.aben.crud.demo.controller;

import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.service.ReactivePoliticianService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/politicians")
public class ReactivePoliticianController {

    @Autowired
    private ReactivePoliticianService reactivePoliticianService;

    @Operation(summary = "Try this endpoint in chrome, postman doesn't support for reactive programming")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<?>> findAll() {
        Flux<?> list = reactivePoliticianService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public Mono<?> findById(@PathVariable int id) {
        return reactivePoliticianService.findById(id);
    }


    @PostMapping
    public Mono<?> save(@RequestBody Politician politician) {
        return reactivePoliticianService.save(politician);
    }


    @PutMapping("/{id}")
    public Mono<?> update(@PathVariable int id, @RequestBody Politician politician) {
        return reactivePoliticianService.update(id, politician);
    }


    @DeleteMapping("/{id}")
    public Mono<?> delete(@PathVariable int id) {
        Mono<Void> monoVoid = reactivePoliticianService.delete(id);
        return Mono.just("Deleted successfully...!");
    }
}
