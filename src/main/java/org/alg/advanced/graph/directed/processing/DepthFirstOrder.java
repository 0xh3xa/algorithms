package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;
import org.alg.advanced.graph.shortestpath.DirectedEdge;
import org.alg.advanced.graph.shortestpath.EdgeWeightedDigraph;
import org.alg.fundamentals.base.Queue;
import org.alg.fundamentals.base.Stack;
import org.alg.fundamentals.impl.queue.ArrayQueue;
import org.alg.fundamentals.impl.stack.ArrayStack;

/**
 * Provides preorder, postorder, reverser postorder
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;

    public DepthFirstOrder(Digraph graph) {
        pre = new ArrayQueue<>();
        post = new ArrayQueue<>();
        marked = new boolean[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    public DepthFirstOrder(EdgeWeightedDigraph graph) {
        pre = new ArrayQueue<>();
        post = new ArrayQueue<>();
        marked = new boolean[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++)
            if (!marked[v])
                dfs(graph, v);
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
    }

    private void dfs(EdgeWeightedDigraph graph, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (DirectedEdge e : graph.adj(graph.getVertices())) {
            int w = e.to();
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        post.enqueue(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Stack<Integer> reversePost() {
        Stack<Integer> reverse = new ArrayStack<>();
        for (int v : post)
            reverse.push(v);
        return reverse;
    }
}
