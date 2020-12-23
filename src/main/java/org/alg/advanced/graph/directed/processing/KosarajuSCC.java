package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;

/**
 * Kosaraju's algorithm for computing strong components
 */
public class KosarajuSCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph graph) {
        marked = new boolean[graph.getVertices()];
        id = new int[graph.getVertices()];
        count = 0;
        DepthFirstOrder order = new DepthFirstOrder(graph);
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}