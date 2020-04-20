package com.alg.advanced.graph;

/**
 * Find paths in graph from source s
 */
public abstract class Path {

    protected Graph graph;

    public Path(Graph graph, int s) {
        this.graph = graph;
    }

    /**
     * Is there a path from s to v
     */
    public abstract boolean hasPathTo(int v);

    /**
     * Path from s to v, null if no such path
     */
    public abstract Iterable<Integer> pathTo(int v);
}