package nl.aben.crud.demo;

import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.model.Student;
import nl.aben.crud.demo.model.emp.Employee;
import nl.aben.crud.demo.repository.EmployeeRepository;
import nl.aben.crud.demo.repository.StudentRepository;
import nl.aben.crud.demo.repository.PoliticianRepository;
import nl.aben.crud.demo.utils.HelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private PoliticianRepository politicianRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Student> students = studentRepository.findAll();
				if (students.isEmpty()) {
					log.info("******* Inserting Students to DB *******");
					studentRepository.saveAll(HelperUtil.studentSupplier.get());
				} else {
					log.info("******* Students stored in DB Size :: {}", students.size());
					log.info("******* Students stored in DB :: {}", students);
				}

			List<Politician> politicians = politicianRepository.findAll();
			if (politicians.isEmpty()) {
				log.info("******* Inserting Politicians to DB *******");
				politicianRepository.saveAll(HelperUtil.politicianSupplier.get());
			} else {
				log.info("******* Politicians stored in DB Size :: {}", politicians.size());
				log.info("******* Politicians stored in DB :: {}", politicians);
			}


			List<Employee> employees = employeeRepository.findAll();
			if (employees.isEmpty()) {
				log.info("******* Inserting Employees to DB *******");
				employeeRepository.saveAll(HelperUtil.employeeSupplier.get());
			} else {
				log.info("******* Employees stored in DB Size :: {}", employees.size());
				log.info("******* Employees stored in DB :: {}", employees);
			}
		};
	}

}
