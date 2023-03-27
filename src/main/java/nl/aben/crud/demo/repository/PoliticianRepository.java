package nl.aben.crud.demo.repository;

import nl.aben.crud.demo.model.Politician;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PoliticianRepository extends JpaRepository<Politician, Integer> {

}
