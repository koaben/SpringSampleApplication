package nl.aben.crud.demo.controller;


import nl.aben.crud.demo.annotation.LogObjectAfter;
import nl.aben.crud.demo.annotation.LogObjectBefore;
import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.service.PoliticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/politicians")
public class PoliticianController {

    @Autowired
    private PoliticianService politicianService;

    @LogObjectAfter
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = politicianService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Politician politician = politicianService.findById(id);
        return ResponseEntity.ok().body(politician);
    }


    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Politician politician) {
        Politician savedPolitician = politicianService.save(politician);
        
//        return ResponseEntity.ok().body(savedPolitician);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
        		.path("/{id}")
        		.buildAndExpand(savedPolitician.getId())
        		.toUri();
        return ResponseEntity.created(uri).body(savedPolitician);
    }


    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Politician politician) {
        Politician updatedPolitician = politicianService.update(id, politician);
        return ResponseEntity.ok().body(updatedPolitician);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        politicianService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
