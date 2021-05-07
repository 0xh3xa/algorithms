package org.alg.advanced.graph.shortestpath;

import org.alg.fundamentals.base.Stack;
import org.alg.fundamentals.impl.queue.IndexMinPQ;
import org.alg.fundamentals.impl.stack.ArrayStack;

/**
 * Dijkstra algorithm implementation for finding shortest path from single
 * source in edge weighted digraphs where weight non negative
 */
public class DijkstraSP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph graph, int s) {
        edgeTo = new DirectedEdge[graph.getVertices()];
        distTo = new double[graph.getVertices()];
        pq = new IndexMinPQ<>(graph.getVertices());

        for (int v = 0; v < graph.getVertices(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : graph.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w))
                pq.decreaseKey(w, distTo[w]);
            else
                pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v))
            return null;

        Stack<DirectedEdge> path = new ArrayStack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }

        return path;
    }

    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Invalid vertex, should be between 0 and " + (V - 1));
    }
}
