package org.alg.advanced.graph.greedy;

/**
 * Represent the edge that connected v-w With the weight between them
 */
public class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * Either endpoint
     */
    public int either() {
        return v;
    }

    /**
     * Other endpoint
     */
    public int other(int vertex) {
        if (vertex == v)
            return w;
        else
            return v;
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight < that.weight)
            return -1;
        else if (this.weight > that.weight)
            return 1;
        return 0;
    }

}