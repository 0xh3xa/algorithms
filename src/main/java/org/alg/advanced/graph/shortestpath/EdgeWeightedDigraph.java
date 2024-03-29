package org.alg.advanced.graph.shortestpath;

import org.alg.fundamentals.impl.Bag;

public class EdgeWeightedDigraph {

    private final int vertices;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int vertices) {
        this.vertices = vertices;
        adj = new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
}
