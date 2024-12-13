package com.poryvai.factorial;

/* 3. Find the sum of the digits in the number 100! (i.e. 100 factorial)
        {Correct answer: 648}*/

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculator {

    // Method to calculate the factorial of a number n
    public BigInteger calculateFactorial(int n) throws IllegalArgumentException{
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative number");
        }

        BigInteger factorial = BigInteger.ONE;

        // Calculate factorial of n
        try {
            for (int i = 2; i <= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
        } catch (Exception e) {
            System.out.println("Error during factorial calculation: "+ e.getMessage());
            throw new RuntimeException("Error during factorial calculation: ", e);
        }
        return factorial;
    }

    // Method to calculate the sum of digits of the factorial of n
    public int calculateDigitSum() throws IllegalArgumentException {
       int n = readInput();
       if (n < 0) {
           System.out.println("Please enter a non-negative integer ");
           return -1;
       }

        try {
            // Get the factorial of n
            BigInteger factorial = calculateFactorial(n);

            // convert the BigInteger to String
            String factorialString = factorial.toString();

            // Calculate the sum of digits
            int sum = 0;
            for (char digitChar : factorialString.toCharArray()) {
                sum += Character.getNumericValue(digitChar);
            }

            return sum;
        } catch (Exception e) {
            System.out.println("Error during digit sum calculation: "+ e.getMessage());
            throw new RuntimeException("Error during digit sum calculation: ", e);
        }
    }

    // Read input from the user
    private int readInput() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        System.out.print("Please enter the number: ");

        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number");
        }

        return n;
    }
}
