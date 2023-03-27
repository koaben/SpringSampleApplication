package nl.aben.crud.demo.service.impl;

import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.repository.PoliticianRepository;
import nl.aben.crud.demo.service.PoliticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PoliticianServiceImpl implements PoliticianService {

    @Autowired
    private PoliticianRepository repository;

    @Override
    public List<Politician> findAll() {
        return repository.findAll();
    }

    @Override
    public Politician findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Politician not found for id :: " + id));
    }

    @Override
    public Politician save(Politician politician) {
        return repository.save(politician);
    }

    @Override
    public Politician update(int id, Politician politician) {
    	repository.findById(id).orElseThrow(() -> new NotFoundException("** Politician not found for id :: " + id));
    	politician.setId(id);
        return repository.save(politician);
    }

    @Override
    public void delete(int id) {
       repository.findById(id).ifPresent(politician -> repository.delete(politician));
    }
}
