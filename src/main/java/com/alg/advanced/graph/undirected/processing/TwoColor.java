package com.alg.advanced.graph.undirected.processing;

import com.alg.advanced.graph.undirected.represent.Graph;

/**
 * Depth-first search to detect if the graph is Bipartite
 */
public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph graph) {
        marked = new boolean[graph.getVertices()];
        color = new boolean[graph.getVertices()];
        for (int s = 0; s < graph.getVertices(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v])
                isTwoColorable = false;
        }
    }

    /**
     * Check if graph is Bipartite
     */
    public boolean isBipartite() {
        return isTwoColorable;
    }
}