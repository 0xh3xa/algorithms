package org.alg.advanced.graph.undirected.processing;

import org.alg.advanced.graph.undirected.represent.Graph;

/**
 * Depth-first search to detect if there is a cycle Is G acyclic? (assumes no
 * self-loops or parallel edges)
 */
public class CycleDetector {

    private boolean[] marked;
    private boolean hasCycle;

    public CycleDetector(Graph graph) {
        marked = new boolean[graph.getVertices()];
        hasCycle = false;
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v, v);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v); // recursive call w, and came from v
            } else if (w != u) { // if w is already visited and w not equals came from u
                hasCycle = true;
            }
        }
    }

    /**
     * Check if graph has cycle
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
