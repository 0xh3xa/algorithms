package com.alg.advanced.graph;

import com.alg.fundamentals.impl.Bag;

public class Graph {

    private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    public Graph(int v) {
        this.vertices = v;
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

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}