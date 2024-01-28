package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductDTO;
import com.devsuperior.uri2621.projections.ProductProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductProjection> products = repository.productsSQL(1, 500,  "E");
		List<ProductDTO> result1 = products.stream().map(ProductDTO::new).collect(Collectors.toList());
		System.out.println("SQL");
		result1.forEach(System.out::println);

		System.out.println("\n\n");

		List<ProductDTO> result2 = repository.productsJPQL(1, 500,  "E");
		System.out.println("JPQL");
		result2.forEach(System.out::println);
	}
}
