package nl.aben.crud.demo.service;

import java.util.List;

import nl.aben.crud.demo.model.Student;

public interface EmployeeQueryService {
	
	List<Student> getAll();

	List<Student> getEmployeeByFirstName(String firstName);

	Student getSingleEmployeeByLastName(String lastName);

	List<Student> getEmployeeByFirstNameLike(String firstName);

	Student getOneEmployeeByFirstName(String firstName);

	List<Student> getEmployeeBySalaryGreaterThan(int salary);

	List<Student> getEmployeeByCondition(Student student);


}
