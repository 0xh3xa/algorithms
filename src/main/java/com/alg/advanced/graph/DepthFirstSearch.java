package com.alg.advanced.graph;

import com.alg.fundamentals.base.Stack;
import com.alg.fundamentals.impl.stack.ArrayStack;

public class DepthFirstSearch extends Path {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstSearch(Graph graph, int s) {
        super(graph, s);
        marked = new boolean[s];
        edgeTo = new int[s];
        this.s = s;
        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(w);
                edgeTo[w] = v;
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