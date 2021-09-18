package io.github.seebaware.spring.data.jpa;

import io.github.seebaware.spring.data.jpa.employee.Employee;
import io.github.seebaware.spring.data.jpa.employee.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}


	public CommandLineRunner run(EmployeeRepository employeeRepository) {

		return (args -> {
			insertEmployees(employeeRepository);
			System.out.println(employeeRepository.findAll());

			System.out.println(employeeRepository.findEmployeeByLastNameContaining("L"));

		});

	}


	private void insertEmployees(EmployeeRepository employeeRepository) {

		employeeRepository.save(new Employee("David", "Mo"));
		employeeRepository.save(new Employee("Steve", "Lo"));

	}

}
