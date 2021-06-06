package org.alg.advanced.graph.undirected.processing;

import java.util.Stack;

import org.alg.advanced.graph.undirected.represent.Graph;

/**
 * Depth-first search to detect if the graph is Bipartite
 */
public class BipartiteDetector {

    private boolean[] marked;
    private boolean[] color;
    private boolean isBipartite;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public BipartiteDetector(Graph graph) {
        marked = new boolean[graph.getVertices()];
        color = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];
        isBipartite = true;
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (cycle != null)
                return;
            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }

    /**
     * Check if graph is Bipartite
     * @return boolean
     */
    public boolean isBipartite() {
        return isBipartite;
    }

    /**
     * get the vertices which consist cycle
     * 
     * @return Iterable
     */
    public Iterable<Integer> oddCycle() {
        return cycle;
    }
}
