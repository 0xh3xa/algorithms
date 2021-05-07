package org.alg.advanced.graph.mst;

import org.alg.fundamentals.base.Queue;
import org.alg.fundamentals.base.UnionFind;
import org.alg.fundamentals.impl.queue.ArrayQueue;
import org.alg.fundamentals.impl.queue.priority.MinPQ;
import org.alg.fundamentals.impl.unionfind.WeightedQuickUnionPassCompression;

/**
 * Kruskal's algorithm
 */
public class KruskalMST {

    private double weight;
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph graph) {
        MinPQ<Edge> pq = new MinPQ<>(graph.getVertices());
        mst = new ArrayQueue<>();
        for (Edge e : graph.edges()) {
            pq.insert(e);
        }

        UnionFind unionFind = new WeightedQuickUnionPassCompression(graph.getVertices());

        while (!pq.isEmpty() && mst.size() < graph.getVertices() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (!unionFind.isConnected(v, w)) {
                unionFind.union(v, w);
                mst.enqueue(e);
                weight += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return this.weight;
    }
}