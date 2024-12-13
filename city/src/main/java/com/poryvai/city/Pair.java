package com.poryvai.city;

public class Pair implements Comparable<Pair> {
    final int node;
    final int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.cost, other.cost);
    }
}
