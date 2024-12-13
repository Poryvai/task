package com.poryvai.city;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPathSolver {
    private final Scanner scanner;
    private final List<Integer> results = new ArrayList<>();

    public ShortestPathSolver(Scanner scanner) {
        this.scanner = scanner;
    }

    // Processes input, builds the graph and finds the shortest paths
    public void solve() {
        try {
            System.out.println("Enter the number of test cases:");
            int testCases = Integer.parseInt(scanner.nextLine());

            while (testCases-- > 0) {
                System.out.println("Enter the number of cities:");
                int cityCount = Integer.parseInt(scanner.nextLine());
                com.poryvai.city.CityGraph cityGraph = new CityGraph();

                for (int i = 1; i <= cityCount; i++) {
                    System.out.println("Enter the name of the city:");
                    String cityName = scanner.nextLine().trim();
                    cityGraph.addCity(cityName, i);

                    System.out.println("Enter the number of neighbors for the city " + cityName + ":");
                    int neighbors = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter the neighbor and the cost of the path (e.g., '2 10'):");
                    for (int j = 0; j < neighbors; j++) {
                        String[] neighborInfo = scanner.nextLine().split(" ");
                        int neighbor = Integer.parseInt(neighborInfo[0]);
                        int cost = Integer.parseInt(neighborInfo[1]);
                        cityGraph.addEdge(i, neighbor, cost);
                    }
                }

                System.out.println("Enter the number of paths to find:");
                int pathCount = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < pathCount; i++) {
                    System.out.println("Enter the cities for the start and end of the path:");
                    String[] pathInfo = scanner.nextLine().split(" ");
                    String startCity = pathInfo[0];
                    String endCity = pathInfo[1];

                    int start = cityGraph.getCityIndex(startCity);
                    int end = cityGraph.getCityIndex(endCity);

                    int result = cityGraph.findShortestPath(start, end);
                    results.add(result);
                }
            }

            // Output the results
            printResults();
        } catch (Exception e) {
            throw new RuntimeException("Error processing input: " + e.getMessage(), e);
        }
    }

    private void printResults() {
        System.out.println("Results:");
        results.forEach(System.out::println); // Print each results
    }
}