package com.alg.advanced.graph.directed.processing;

import com.alg.advanced.graph.directed.represent.Digraph;
import com.alg.fundamentals.base.Stack;
import com.alg.fundamentals.impl.stack.ArrayStack;

/**
 * Detect cycle in directed graph
 */
public class DirectedCycleDetector {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle
    private boolean[] onStack; // vertices on recursive call stack

    public DirectedCycleDetector(Digraph graph) {
        onStack = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];
        marked = new boolean[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v])
                dfs(graph, v);
        }
    }

    private void dfs(Digraph graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (hasCycle())
                return;
            else if (!marked[v]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                cycle = new ArrayStack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}