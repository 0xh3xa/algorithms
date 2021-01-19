package org.alg.advanced.graph.mst;

import org.alg.fundamentals.impl.Bag;

public class EdgeWeightedGraph {

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

    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int v = 0; v < vertices; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v)
                    bag.add(e);
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0)
                        bag.add(e);
                    selfLoops++;
                }
            }
        }
        return bag;
    }
}
