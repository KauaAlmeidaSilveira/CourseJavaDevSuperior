package com.devsuperior.domainModelORM;

import com.devsuperior.domainModelORM.DTO.ProductDTO;
import com.devsuperior.domainModelORM.entities.Product;
import com.devsuperior.domainModelORM.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DomainModelOrmApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DomainModelOrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Product product = productRepository.findByName("Tera");
		//System.out.println(product);
	}
}
