package com.alg.advanced.graph.undirected.util;

import com.alg.advanced.graph.undirected.represent.Graph;

/**
 * Util class for graph to computer operation like degree, maxDegree,
 * averageDegree, etc
 */
public final class GraphUtil {

    private GraphUtil() {
        throw new IllegalAccessError();
    }

    /**
     * computer the degree of (v), number of vertices connected to (v)
     */
    public final static int degree(Graph graph, int v) {
        int degree = 0;
        for (int w : graph.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * computer maximum degree, which vertex has max number of connected vertices to
     * it
     */
    public final static int maxDegree(Graph graph) {
        int max = 0, deg;
        for (int v = 0; v < graph.getVertices(); v++) {
            deg = degree(graph, v);
            if (deg > max) {
                max = deg;
            }
        }
        return max;
    }

    /**
     * computer average degree
     */
    public final static double averageDegree(Graph graph) {
        return 2.0 * graph.getEdges() / graph.getVertices();
    }

    /**
     * count self-loops
     */
    public final static int numberOfSelfLoops(Graph graph) {
        int count = 0;
        for (int v = 0; v < graph.getVertices(); v++) {
            for (int w : graph.adj(v)) {
                if (v == w)
                    count++;
            }
        }
        return count / 2; // each edge counted twice
    }
}