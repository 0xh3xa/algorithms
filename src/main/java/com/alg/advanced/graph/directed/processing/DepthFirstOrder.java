package com.alg.advanced.graph.directed.processing;

import com.alg.advanced.graph.directed.represent.Digraph;
import com.alg.fundamentals.base.Queue;
import com.alg.fundamentals.base.Stack;
import com.alg.fundamentals.impl.queue.QueueArray;
import com.alg.fundamentals.impl.stack.ArrayStack;

public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph graph) {
        pre = new QueueArray<>();
        post = new QueueArray<>();
        reversePost = new ArrayStack<>();
        marked = new boolean[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v])
                dfs(graph, v);
        }
    }

    private void dfs(Digraph graph, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : graph.adj(v))
            if (!marked[v])
                dfs(graph, w);
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}