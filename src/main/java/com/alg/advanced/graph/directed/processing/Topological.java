package com.alg.advanced.graph.directed.processing;

import java.util.Stack;

import com.alg.advanced.graph.directed.represent.Digraph;
import com.alg.advanced.graph.directed.represent.SymbolDigraph;

/**
 * Put vertices on order
 */
public class Topological {

    private Iterable<Integer> order;
    private Stack<Integer> stack;

    public Topological(Digraph graph) {
        DirectedCycleDetector finder = new DirectedCycleDetector(graph);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            stack = dfs.reversePost();
        }
    }

    public Stack<Integer> order() {
        return stack;
    }

    public boolean hasOrder() {
        return order != null;
    }

    public boolean isDag() {
        return hasOrder();
    }

    // public static void main(String[] a) throws Exception {
    //     String FILE_NAME = "C:\\Users\\space\\Desktop\\jobs.txt";

    //     SymbolDigraph symbolDigraph;

    //     symbolDigraph = new SymbolDigraph(FILE_NAME, "/");

    //     Topological topological = new Topological(symbolDigraph.graph());

    //     // Assert
    //     while (!topological.order().empty()) {
    //         System.out.println(symbolDigraph.name(topological.order().pop()));
    //     }
    // }
}