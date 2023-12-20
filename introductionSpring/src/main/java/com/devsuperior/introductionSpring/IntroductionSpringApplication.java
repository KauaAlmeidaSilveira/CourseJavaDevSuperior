package com.devsuperior.introductionSpring;

import com.devsuperior.introductionSpring.entities.Employee;
import com.devsuperior.introductionSpring.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionSpringApplication implements CommandLineRunner {

	@Autowired
	private SalaryService salaryService;

	public static void main(String[] args) {
		SpringApplication.run(IntroductionSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(salaryService.netSalary(new Employee("kaua", 4000.0)));
	};
}
