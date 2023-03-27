package nl.aben.crud.demo.service;

import nl.aben.crud.demo.model.emp.Employee;

import java.util.List;

public interface EmployeeService {

    List<?> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

	Employee update(int id, Employee employee);

    void delete(int id);

}
