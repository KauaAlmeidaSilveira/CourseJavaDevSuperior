package com.devsuperior.DSCommerce;

import com.devsuperior.DSCommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DSCommerceApplication{
	public static void main(String[] args) {
		SpringApplication.run(DSCommerceApplication.class, args);
	}
}
