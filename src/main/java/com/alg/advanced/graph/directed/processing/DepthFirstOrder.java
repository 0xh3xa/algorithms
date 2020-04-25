package com.alg.advanced.graph.directed.processing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import com.alg.advanced.graph.directed.represent.Digraph;

public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;

    public DepthFirstOrder(Digraph graph) {
        pre = new ArrayDeque<>();
        post = new ArrayDeque<>();
        marked = new boolean[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v])
                dfs(graph, v);
        }
    }

    private void dfs(Digraph graph, int v) {
        pre.add(v);
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        post.add(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Stack<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        while (!post.isEmpty()) {
            reverse.push(post.poll());
        }
        return reverse;
    }
}