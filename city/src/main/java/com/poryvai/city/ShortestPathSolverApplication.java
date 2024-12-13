package com.poryvai.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ShortestPathSolverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortestPathSolverApplication.class, args);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter data for the task:");

            ShortestPathSolver solver = new ShortestPathSolver(scanner);
            solver.solve();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
