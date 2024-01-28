package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.repositories.EmpregadoRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<EmpregadoDeptProjection> empregadoDeptProjections = repository.searchSQL();
		List<EmpregadoDeptDTO> result1 = empregadoDeptProjections.stream().map(EmpregadoDeptDTO::new).collect(Collectors.toList());
		System.out.println("SQL");
		result1.forEach(System.out::println);

		System.out.println("\n\n");
		List<EmpregadoDeptDTO> result2 = repository.searchJPQL();
		System.out.println("JPQL");
		result2.forEach(System.out::println);
	}
}
