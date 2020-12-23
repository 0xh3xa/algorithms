package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;
import org.alg.fundamentals.base.Queue;
import org.alg.fundamentals.base.Stack;
import org.alg.fundamentals.impl.queue.ArrayQueue;
import org.alg.fundamentals.impl.stack.ArrayStack;

/**
 * BFS graph-processing route
 */
public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstPaths(Digraph graph, int s) {
        marked = new boolean[graph.getVertices()];
        distTo = new int[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            distTo[v] = Integer.MAX_VALUE;
        }
        bfs(graph, s);
    }

    private void bfs(Digraph graph, int s) {
        Queue<Integer> q = new ArrayQueue<>();
        for (int v = 0; v < graph.getVertices(); v++) {
            distTo[v] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new ArrayStack<>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }
}
