package com.poryvai.parentheses;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParenthesesTests {

	private final Parentheses parentheses= new Parentheses();


	@Test
	public void testGenerateParenthesesForZero(){
		simulateUserInput("0");
		List<String> results = parentheses.getParentheses();
		assertEquals(0, results.size());
	}

	@Test
	public void testGenerateParenthesesForOne(){
		simulateUserInput("1");
		List<String> results = parentheses.getParentheses();
		assertEquals(1, results.size());
	}

	@Test
	public void testGenerateParenthesesForTwo(){
		simulateUserInput("2");
		List<String> results = parentheses.getParentheses();
		assertEquals(2, results.size());
	}

	@Test
	public void testGenerateParenthesesForThree(){
		simulateUserInput("3");
		List<String> results = parentheses.getParentheses();
		assertEquals(5, results.size());
	}
	@Test
	public void testGenerateParenthesesForInvalidInput(){
		simulateUserInput("-1");
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
			parentheses.getParentheses();
		});
		assertEquals("Input must be a non-negative integer", exception.getMessage());
	}

	// method for simulating user input
	private void simulateUserInput(String input) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
}
