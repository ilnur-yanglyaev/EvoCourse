package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Task8Application {
	private final Calculator calculator;
	public Task8Application(@Qualifier("calculator") Calculator calculator) {
		this.calculator = calculator;
	}
	public static void main(String[] args) {
		SpringApplication.run(Task8Application.class, args);
	}

	@Bean
	public boolean outToConsole() throws Exception {
		Scanner in = new Scanner(System.in);

		System.out.println("Введите число a");
		double a = in.nextDouble();
		System.out.println("Введите число b");
		double b = in.nextDouble();
		System.out.println("Введите тип операции: " + calculator.getSupportedOperations());
		String operationType = in.next();

		calculator.calc(operationType, a, b);
		return true;
	}
}
