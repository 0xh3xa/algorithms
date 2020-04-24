package com.alg.advanced.graph.directed.processing;

import com.alg.advanced.graph.directed.represent.Digraph;

/**
 * Put vertices on order
 */
public class TopologicalSort {

    private Iterable<Integer> order;

    public TopologicalSort(Digraph graph) {
        DirectedCycleDetector finder = new DirectedCycleDetector(graph);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDag() {
        return order == null;
    }
}