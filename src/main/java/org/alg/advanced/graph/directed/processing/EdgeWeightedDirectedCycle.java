package org.alg.advanced.graph.directed.processing;

import java.util.Stack;

import org.alg.advanced.graph.shortestpath.DirectedEdge;
import org.alg.advanced.graph.shortestpath.EdgeWeightedDigraph;

/**
 * Detect cycle in Edge Weighted graph
 */
public class EdgeWeightedDirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle
    private boolean[] onStack; // vertices on recursive call stack

    public EdgeWeightedDirectedCycle(EdgeWeightedDigraph graph) {
        onStack = new boolean[graph.getVertices()];
        marked = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v] && cycle == null)
                dfs(graph, v);
        }
    }

    private void dfs(EdgeWeightedDigraph graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : graph.adj(v)) {
            int w = e.to();
            if (cycle != null) {
                // short circuit if directed cycle found
                return;
            } else if (!marked[w]) {
                // found new vertex, so recur
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                // trace back directed cycle
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
