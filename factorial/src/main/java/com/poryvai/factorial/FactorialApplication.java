package com.poryvai.factorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactorialApplication.class, args);

		FactorialCalculator factorialCalculator = new FactorialCalculator();

		// Call the method to calculate the digit sum
		int sum = factorialCalculator.calculateDigitSum();

		System.out.println("The sum of the digits of the factorials is: " + sum);


	}
}
