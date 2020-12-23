package org.alg.advanced.graph.undirected.processing;

import org.alg.advanced.graph.undirected.represent.Graph;

/**
 * Depth-first search to find connected components in a graph
 */
public class ConnectedComponent {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponent(Graph graph) {
        marked = new boolean[graph.getVertices()];
        id = new int[graph.getVertices()];
        for (int s = 0; s < graph.getVertices(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w])
                dfs(graph, w);
        }
    }

    /**
     * two vertices are connected if have the same id
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * the id of the vert
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * sum of the connected components in the graph
     */
    public int count() {
        return count;
    }
}
