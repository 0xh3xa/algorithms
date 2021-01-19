package org.alg.advanced.graph.mst;

import org.alg.fundamentals.base.Queue;
import org.alg.fundamentals.base.UnionFind;
import org.alg.fundamentals.impl.queue.ArrayQueue;
import org.alg.fundamentals.impl.queue.priority.MinPQ;
import org.alg.fundamentals.impl.unionfind.WeightedQuickUnionPassCompression;

/**
 * Prim's algorithm
 */
public class LazyPrimMST {

    private double weight;
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph) {
        pq = new MinPQ<>(graph.getVertices());
        mst = new ArrayQueue<>();
        marked = new boolean[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) { // run Prim from all vertices to
            if (!marked[v])
                prim(graph, v); // get a minimum spanning forest
        }
    }

    private void prim(EdgeWeightedGraph graph, int s) {
        scan(graph, s);

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w])
                continue;
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v])
                scan(graph, v); // v become part of tree
            if (!marked[w])
                scan(graph, w); // w become part of tree
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been
    // scanned
    private void scan(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge e : graph.adj(v))
            if (!marked[e.other(v)])
                pq.insert(e);
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return this.weight;
    }
}