package org.alg.advanced.graph.directed.processing;

import org.alg.advanced.graph.directed.represent.Digraph;

/**
 * All-pairs reachability
 */
public class TransitiveClosure {

    private DirectedDFS[] all;

    public TransitiveClosure(Digraph graph) {
        all = new DirectedDFS[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            all[v] = new DirectedDFS(graph, v);
        }
    }

    public boolean reachable(int v, int w) {
        return all[v].visited(w);
    }

}