package com.alg.advanced.graph.undirected.processing;

import com.alg.advanced.graph.undirected.represent.Graph;

/**
 * DFS algorithm, graph-processing routine
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.getVertices()];
        count = 0;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        count++;
        marked[v] = true; // mark v as visited
        for (int w : graph.adj(v)) { // get adjacency to v
            if (!marked[w]) { // visit if not marked
                dfs(graph, w); // recursive
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}