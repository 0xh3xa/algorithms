package com.alg.advanced.graph;

public abstract class Path {

    protected Graph graph;

    public Path(Graph graph, int s) {
        this.graph = graph;
    }

    public abstract boolean hasPathTo(int v);

    public abstract Iterable<Integer> pathTo(int v);
}