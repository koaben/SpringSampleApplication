package nl.aben.crud.demo.repository;

import nl.aben.crud.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByFirstName(String firstName);

    List<Student> findByFirstNameLike(String firstName);


}
