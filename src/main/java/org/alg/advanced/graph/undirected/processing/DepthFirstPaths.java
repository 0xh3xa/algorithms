package org.alg.advanced.graph.undirected.processing;

import org.alg.advanced.graph.undirected.represent.Graph;
import org.alg.fundamentals.base.Stack;
import org.alg.fundamentals.impl.stack.ArrayStack;

/**
 * DFS algorithm, graph-processing routine
 */
public class DepthFirstPaths {

    private int s;
    private int[] edgeTo;
    private boolean[] marked;

    public DepthFirstPaths(Graph graph, int s) {
        this.s = s;
        this.edgeTo = new int[graph.getVertices()];
        this.marked = new boolean[graph.getVertices()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true; // mark v as visited
        for (int w : graph.adj(v)) { // get adjacency to v
            if (!marked[w]) { // visit if not marked
                edgeTo[w] = v; // add edge from w to v
                dfs(graph, w); // recursive
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new ArrayStack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
