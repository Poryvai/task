package com.poryvai.city;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityGraph {
    private final Map<String, Integer> cityToIndex = new HashMap<>();
    private final Map<Integer, List<Edge>> graph = new HashMap<>();

    // Adds a city with a unique index
    public void addCity(String cityName, int index) {
        cityToIndex.put(cityName, index);
        graph.putIfAbsent(index, new ArrayList<>());
    }

    // Adds an edge between two cities
    public void addEdge(int from, int to, int cost) {
        graph.get(from).add(new Edge(to, cost));
    }

    // Returns the index of a city by name
    public int getCityIndex(String cityName) {
        if (!cityToIndex.containsKey(cityName)) {
            throw new IllegalArgumentException("City not found: " + cityName);
        }
        return cityToIndex.get(cityName);
    }

    // Finds the shortest path using Dijkstra's algorithm
    public int findShortestPath(int start, int end) {
        return Dijkstra.findShortestPath(graph, start, end);
    }
}
