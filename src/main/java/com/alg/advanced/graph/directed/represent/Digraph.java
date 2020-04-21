package com.alg.advanced.graph.directed;

import com.alg.fundamentals.impl.Bag;

/**
 * Graph representation using vertices, adjacency and edges
 */
public class Digraph {

    private static final String NEW_LINE = System.lineSeparator();

    private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    /**
     * create graph of size of v vertices
     */
    public Digraph(int v) {
        if (v < 0)
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.vertices = v;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * get number of vertices
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * get number of edge
     */
    public int getEdges() {
        return edges;
    }

    /**
     * add edge v-w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        edges++;
    }

    /**
     * get number of adjacency to vertex v
     */
    public int degree(int v) {
        return adj[v].size();
    }

    /**
     * get adjacency to vertex v
     */
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