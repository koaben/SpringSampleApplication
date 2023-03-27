package nl.aben.crud.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.model.emp.Address;
import nl.aben.crud.demo.model.emp.Employee;
import nl.aben.crud.demo.model.Student;
import nl.aben.crud.demo.model.emp.PhoneNumber;

public class HelperUtil {

    private HelperUtil() {
    }


    public static Supplier<List<Student>> studentSupplier = () ->
            Arrays.asList(
		            Student.builder().rollNo(1).firstName("Koen").lastName("Aben").marks(300.0f).build(),
		            Student.builder().rollNo(2).firstName("Peter").lastName("Janssen").marks(950.0f).build(),
		            Student.builder().rollNo(3).firstName("Jesse").lastName("de Vries").marks(500.0f).build(),
		            Student.builder().rollNo(4).firstName("Stephan").lastName("Bergkamp").marks(600.0f).build(),
		            Student.builder().rollNo(5).firstName("Thijs").lastName("Kluivert").marks(700.0f).build(),
		            Student.builder().rollNo(6).firstName("Johan").lastName("de Jong").marks(800.0f).build(),
		            Student.builder().rollNo(7).firstName("Jasper").lastName("Weghorst").marks(900.0f).build(),
		            Student.builder().rollNo(8).firstName("Ramon").lastName("Cilessen").marks(800.0f).build(),
		            Student.builder().rollNo(9).firstName("Erwin").lastName("Hartman").marks(900.0f).build(),
		            Student.builder().rollNo(10).firstName("Rob").lastName("Depay").marks(800.0f).build()
            );



    public static Supplier<List<Politician>> politicianSupplier = () ->
            Arrays.asList(
                    Politician.builder().firstName("Mark").lastName("Rutte").party("VVD").age(56).inCabinet(true).build(),
                    Politician.builder().firstName("Sigrid").lastName("Kaag").party("D66").age(61).inCabinet(true).build(),
                    Politician.builder().firstName("Geert").lastName("Wilders").party("LPF").age(59).inCabinet(false).build(),
                    Politician.builder().firstName("Jesse").lastName("Klaver").party("GroenLinks").age(36).inCabinet(false).build(),
                    Politician.builder().firstName("Wopke").lastName("Hoekstra").party("CDA").age(47).inCabinet(true).build()
            );




	public static Supplier<List<Employee>> employeeSupplier = () -> {

		Employee rahul = Employee.builder()
				.id(1)
				.firstName("Koen")
				.lastName("Aben")
				.age(28)
				.noOfChildrens(0)
				.spouse(true)
				.address(Address.builder()
						.id(1)
						.streetAddress("RS road")
						.city("Eindhoven")
						.state("Noord Brabant")
						.country("Nederland")
						.postalCode("5656RW")
						.build()
				)
				.hobbies(Arrays.asList("Coding", "Reading"))
				.build();

		PhoneNumber rahulsNo = PhoneNumber.builder()
				.id(1)
				.type("Mobile")
				.number("1234567890")
				.employee(rahul)
				.build();

		rahul.setPhoneNumbers(Arrays.asList(rahulsNo));






		Employee aryan = Employee.builder()
				.id(1)
				.firstName("Peter")
				.lastName("Janssen")
				.age(28)
				.noOfChildrens(0)
				.spouse(true)
				.address(Address.builder()
						.id(1)
						.streetAddress("A road")
						.city("Eindhoven")
						.state("Noord Brabant")
						.country("Nederland")
						.postalCode("5660RA")
						.build()
				)
				.hobbies(Arrays.asList("Dancing", "Cooking"))
				.build();

		PhoneNumber aryansNumber = PhoneNumber.builder()
				.id(1)
				.type("Mobile")
				.number("1234555555")
				.employee(aryan)
				.build();

		aryan.setPhoneNumbers(Arrays.asList(aryansNumber));


		return Arrays.asList(rahul, aryan);
	};
}
