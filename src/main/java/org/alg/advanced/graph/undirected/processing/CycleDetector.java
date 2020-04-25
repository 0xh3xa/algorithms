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
        for (int s = 0; s < graph.getVertices(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w])
                dfs(graph, w, v);
            else if (w != u)
                hasCycle = true;
        }
    }

    /**
     * Check if graph has cycle
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
