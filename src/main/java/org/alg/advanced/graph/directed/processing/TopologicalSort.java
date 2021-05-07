package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;
import org.alg.advanced.graph.shortestpath.EdgeWeightedDigraph;
import org.alg.fundamentals.base.Stack;

/**
 * Put vertices on order
 */
public class TopologicalSort {

    private Stack<Integer> order;

    public TopologicalSort(Digraph graph) {
        DirectedCycleDetector finder = new DirectedCycleDetector(graph);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }

    public TopologicalSort(EdgeWeightedDigraph graph) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(graph);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }

    public Stack<Integer> order() {
        return order;
    }

    public boolean hasOrder() {
        return order != null;
    }

    public boolean isDag() {
        return hasOrder();
    }
}
