package com.devsuperior.desafio01;

import com.devsuperior.desafio01.entities.Order;
import com.devsuperior.desafio01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio01Application implements CommandLineRunner {

    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Desafio01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o código: ");
		int code = sc.nextInt();

		System.out.print("Digite o valor basico: ");
		double basic = sc.nextDouble();

		System.out.print("Digite a porcentagem de desconto: ");
		double discount = sc.nextDouble();

        System.out.printf("%nPedido código %d%n", code);
        System.out.printf("Valor total: R$ %.2f", orderService.total(new Order(code, basic, discount)));

		sc.close();
    }
}
