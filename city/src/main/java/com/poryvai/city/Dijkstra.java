package com.poryvai.city;

import java.util.*;

public class Dijkstra {

    // Finds the shortest path between two nodes
    public static int findShortestPath(Map<Integer, List<Edge>> graph, int start, int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> distances = new HashMap<>();

        // Initialize distances
        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Start from the source
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            int currentCost = current.cost;

            // Found the destination
            if (currentNode == end) {
                return currentCost;
            }

            if (currentCost > distances.get(currentNode)) {
                continue;
            }

            // Process neighbors
            for (Edge neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int newCost = currentCost + neighbor.cost;
                if (newCost < distances.get(neighbor.destination)) {
                    distances.put(neighbor.destination, newCost);
                    pq.add(new Pair(neighbor.destination, newCost));
                }
            }
        }
        return -1; // No path found
    }
}


