package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;
import org.alg.fundamentals.base.Queue;
import org.alg.fundamentals.base.Stack;
import org.alg.fundamentals.impl.queue.ArrayQueue;
import org.alg.fundamentals.impl.stack.ArrayStack;

public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reverseOrder;

    public DepthFirstOrder(Digraph graph) {
        pre = new ArrayQueue<>();
        post = new ArrayQueue<>();
        reverseOrder = new ArrayStack<>();
        marked = new boolean[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v])
                dfs(graph, v);
        }
    }

    private void dfs(Digraph graph, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        post.enqueue(v);
        reverseOrder.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Stack<Integer> reversePost() {
        return reverseOrder;
    }
}
