package com.alg.advanced.graph.undirected.processing;

import com.alg.advanced.graph.undirected.represent.Graph;
import com.alg.fundamentals.base.Stack;
import com.alg.fundamentals.impl.stack.ArrayStack;

/**
 * DFS algorithm, graph-processing routine
 */
public class DepthFirstPaths extends Path {

    private int s;
    private int[] edgeTo;
    private boolean[] marked;

    public DepthFirstPaths(Graph graph, int s) {
        super(graph, s);
        this.s = s;
        this.edgeTo = new int[graph.getVertices()];
        this.marked = new boolean[graph.getVertices()];
        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true; // mark v as visited
        for (int w : graph.adj(v)) { // get adjacency to v
            if (!marked[w]) { // visit if not marked
                edgeTo[w] = v; // add edge from w to v
                dfs(w); // recursive
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
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