package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;
import org.alg.fundamentals.base.Stack;

/**
 * Put vertices on order
 */
public class Topological {

    // private Iterable<Integer> order;
    private Stack<Integer> order;

    public Topological(Digraph graph) {
        DirectedCycleDetector finder = new DirectedCycleDetector(graph);
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

    // public static void main(String[] a) throws Exception {
    // String FILE_NAME = "C:\\Users\\space\\Desktop\\jobs.txt";

    // SymbolDigraph symbolDigraph;

    // symbolDigraph = new SymbolDigraph(FILE_NAME, "/");

    // Topological topological = new Topological(symbolDigraph.graph());

    // // Assert
    // while (!topological.order().empty()) {
    // System.out.println(symbolDigraph.name(topological.order().pop()));
    // }
    // }
}
