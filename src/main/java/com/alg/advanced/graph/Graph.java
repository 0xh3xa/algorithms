package com.alg.advanced.graph;

import com.alg.fundamentals.impl.Bag;

public class Graph {

    private static final String NEW_LINE = System.lineSeparator();

    private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    public Graph(int v) {
        if (v < 0)
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.vertices = v;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int v = 0; v < vertices; v++) {
            builder.append(v + ": ");
            for (int w : adj[v]) {
                builder.append(w + " ");
            }
            builder.append(NEW_LINE);
        }
        return builder.toString();
    }
}