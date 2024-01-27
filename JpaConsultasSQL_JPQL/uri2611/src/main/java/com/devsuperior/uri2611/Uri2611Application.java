package com.devsuperior.uri2611;

import com.devsuperior.uri2611.DTO.MovieDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.modelmbean.ModelMBeanConstructorInfo;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieProjection> movies = movieRepository.moviesSQL("horror");
		List<MovieDTO> result = movies.stream().map(MovieDTO::new).collect(Collectors.toList());
		System.out.println("RESULT 1 - SQL");
		result.forEach(System.out::println);

		System.out.println("\n\n\n");

		List<MovieDTO> result2 = movieRepository.moviesJPQL("ACTION");
		System.out.println("RESULT 2 - JPQL");
		result2.forEach(System.out::println);
	}
}
