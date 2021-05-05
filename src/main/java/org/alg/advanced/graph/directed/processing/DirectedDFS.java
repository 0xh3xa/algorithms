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

    public DirectedDFS(Digraph graph, Iterable<Integer> sources) {
        marked = new boolean[graph.getVertices()];
        for (int v : sources) {
            if (!marked[v])
                dfs(graph, v);
        }
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
