package nl.aben.crud.demo.service;


import java.util.List;

import nl.aben.crud.demo.model.Student;

public interface StudentService {
	
	List<Student> getAll();

	List<Student> getStudentByFirstName(String firstName);

	Student getOneStudentByFirstName(String firstName);

	List<Student> getStudentByFirstNameLike(String firstName);

	Student getStudentById(int empId);
	
	Student getStudentByLastName(String lastName);

	List<Student> getStudentBySalaryGreaterThan(int salary);
	
	List<Student> getStudentByCondition(Student student);

}
