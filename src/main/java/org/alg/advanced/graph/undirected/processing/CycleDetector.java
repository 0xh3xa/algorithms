package org.alg.advanced.graph.undirected.processing;

import org.alg.advanced.graph.undirected.represent.Graph;
import org.alg.fundamentals.base.Stack;
import org.alg.fundamentals.impl.stack.ArrayStack;

/**
 * class representation for determining whether the undirected graph has a cycle
 */
public class CycleDetector {

    private boolean[] marked;
    private int[] edgeTo;
    private boolean hasCycle;
    private Stack<Integer> cycle;

    public CycleDetector(Graph graph) {
        marked = new boolean[graph.getVertices()];
        edgeTo = new int[graph.getVertices()];
        hasCycle = false;
        for (int v = 0; v < graph.getVertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v, -1);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (cycle != null)
                return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w, v); // recursive call w, and came from v
            } else if (w != u) { // if w is already visited and w not equals came from u
                hasCycle = true;
                cycle = new ArrayStack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v); // add v twice because it's cycle start and end
            }
        }
    }

    /**
     * Check if graph has cycle
     * @return boolean
     */
    public boolean hasCycle() {
        return hasCycle;
    }

    /**
     * get the vertices which consist cycle
     * @return Iterable
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}
