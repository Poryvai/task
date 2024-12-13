package com.poryvai.factorial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FactorialClaculatorTests {

	FactorialCalculator factorialCalculator = new FactorialCalculator();

	@Test
	public void testCalculateDigitSum() {
		simulateUserInput("0");
		assertEquals(1, factorialCalculator.calculateDigitSum());

		simulateUserInput("1");
		assertEquals(1, factorialCalculator.calculateDigitSum());

		simulateUserInput("5");
		assertEquals(3, factorialCalculator.calculateDigitSum());

		simulateUserInput("100");
		assertEquals(648, factorialCalculator.calculateDigitSum());
	}

	@Test
	public void testCalculateDigitSumForNegativeInput() {
		simulateUserInput("-1");
		assertEquals(-1, factorialCalculator.calculateDigitSum());
	}

	@Test
	public void testCalculateFactorial() {
		assertEquals(BigInteger.ONE , factorialCalculator.calculateFactorial(0));

		assertEquals(BigInteger.ONE , factorialCalculator.calculateFactorial(1));

		assertEquals(new BigInteger("120"), factorialCalculator.calculateFactorial(5));
	}

	@Test
	public void testCalculateFactorialForNegativeInput() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			factorialCalculator.calculateFactorial(-1);
		});
		assertEquals("Factorial is not defined for negative number", exception.getMessage());
	}
	// method for simulating user input
	private void simulateUserInput(String input) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}

}
