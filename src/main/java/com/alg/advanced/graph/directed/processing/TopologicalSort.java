package com.alg.advanced.graph.directed.processing;

import com.alg.advanced.graph.directed.represent.Digraph;
import com.alg.advanced.graph.directed.represent.SymbolDigraph;

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

    public boolean hasOrder() {
        return order != null;
    }

    public boolean isDag() {
        return hasOrder();
    }

    public static void main(String[] a) throws Exception {
        String FILE_NAME = "C:\\Users\\space\\Desktop\\jobs.txt";

        SymbolDigraph symbolDigraph;

        symbolDigraph = new SymbolDigraph(FILE_NAME, "/");

        TopologicalSort topological = new TopologicalSort(symbolDigraph.graph());

        // Assert
        for (int v : topological.order()) {
            System.out.println(symbolDigraph.name(v));
        }
    }
}