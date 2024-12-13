package com.poryvai.parentheses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ParenthesesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParenthesesApplication.class, args);

		Parentheses parentheses = new Parentheses();

		List<String> listParentheses = parentheses.getParentheses();

		System.out.println("Number of the correct parentheses expression: " + listParentheses.size());
		System.out.println(listParentheses);

	}
}
