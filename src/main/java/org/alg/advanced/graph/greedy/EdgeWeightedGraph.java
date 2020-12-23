package org.alg.advanced.graph.greedy;

import org.alg.fundamentals.impl.Bag;

public class EdgeWeightedGraph {

    private static final String NEW_LINE = System.lineSeparator();

    private final int vertices;
    private Bag<Edge>[] adj;

    /**
     * create graph of size of v vertices
     */
    public EdgeWeightedGraph(int v) {
        if (v < 0)
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.vertices = v;
        adj = (Bag<Edge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<Edge>();
        }
    }

    /**
     * get number of vertices
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * connect two vertices with each other
     */
    public void addEdge(Edge edge) {
        int v = edge.either(), w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
    }

    /**
     * get adjacency to vertex v
     */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}