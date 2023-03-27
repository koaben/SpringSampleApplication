package nl.aben.crud.demo.service.impl;

import nl.aben.crud.demo.model.emp.Employee;
import nl.aben.crud.demo.repository.EmployeeRepository;
import nl.aben.crud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Employee not found for id :: " + id));
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(int id, Employee employee) {
    	repository.findById(id).orElseThrow(() -> new NotFoundException("** Employee not found for id :: " + id));
        
    	employee.setId(id);
    	return repository.save(employee);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(Employee -> repository.delete(Employee));
    }
}
