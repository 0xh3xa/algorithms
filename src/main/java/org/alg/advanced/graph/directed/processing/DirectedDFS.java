package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;

/**
 * Directed DFS search algorithm for Digraph
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph graph, int s) {
        marked = new boolean[graph.getVertices()];
        dfs(graph, s);
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w])
                dfs(graph, w);
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }
}
