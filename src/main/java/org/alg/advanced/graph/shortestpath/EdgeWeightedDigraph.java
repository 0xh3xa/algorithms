package org.alg.advanced.graph.shortestpath;

import org.alg.fundamentals.impl.Bag;

public class EdgeWeightedDigraph {

    private final int vertices;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int vertices) {
        this.vertices = vertices;
        adj = (Bag<DirectedEdge>[]) new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
}
