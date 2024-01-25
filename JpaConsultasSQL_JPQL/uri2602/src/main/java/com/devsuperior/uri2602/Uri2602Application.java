package com.devsuperior.uri2602;

import com.devsuperior.uri2602.DTO.CustomerDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Uri2602Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<CustomerMinProjection> list = repository.search1("rs");
        List<CustomerDTO> result1 = list.stream().map(CustomerDTO::new).collect(Collectors.toList());

        System.out.println("*** Result SQL ***");

        result1.forEach(System.out::println);


        System.out.println("\n\n");


        List<CustomerDTO> result2 = repository.search2("rs");

        System.out.println("*** Result JPQL ***");

        result2.forEach(System.out::println);

    }
}
