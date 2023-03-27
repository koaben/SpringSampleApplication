package nl.aben.crud.demo.service;

import nl.aben.crud.demo.model.Politician;

import java.util.List;

public interface PoliticianService {

    List<?> findAll();

    Politician findById(int id);

    Politician save(Politician politician);

    Politician update(int id, Politician politician);

    void delete(int id);
}
