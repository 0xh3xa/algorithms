package org.alg.advanced.string.search.regex;

import org.alg.advanced.graph.directed.processing.DirectedDFS;
import org.alg.advanced.graph.directed.represent.Digraph;
import org.alg.fundamentals.base.Stack;
import org.alg.fundamentals.impl.Bag;
import org.alg.fundamentals.impl.stack.ArrayStack;

/**
 * class represents NFA for regular expression search
 */
public class NFA {

    private char[] re;
    private Digraph graph;
    private int M;
    private String regexp;

    public NFA(String regexp) {
        this.regexp = regexp;
        re = regexp.toCharArray();
        M = regexp.length();
        graph = buildEpsilonTransitionDigraph();
    }

    private Digraph buildEpsilonTransitionDigraph() {
        Digraph g = new Digraph(M + 1);
        Stack<Integer> ops = new ArrayStack<>();
        for (int i = 0; i < M; i++) {
            int lp = i;
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|')
                ops.push(i);
            else if (regexp.charAt(i) == ')') {
                int or = ops.pop();
                if (regexp.charAt(or) == '|') {
                    lp = ops.pop();
                    g.addEdge(lp, or + 1);
                    g.addEdge(or, i);
                } else
                    lp = or;
            }

            if (i < M - 1 && regexp.charAt(i + 1) == '*') {
                g.addEdge(lp, i + 1);
                g.addEdge(i + 1, lp);
            }
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')')
                g.addEdge(i, i + 1);
        }
        return g;
    }

    public boolean recognize(String txt) {
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(graph, 0);
        for (int v = 0; v < graph.getVertices(); v++) {
            if (dfs.visited(v))
                pc.add(v);
        }

        for (int i = 0; i < txt.length(); i++) {
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v == M)
                    continue;
                if ((re[v] == txt.charAt(i)) || re[v] == '.')
                    match.add(v + 1);
            }

            dfs = new DirectedDFS(graph, match);
            pc = new Bag<>();
            for (int v = 0; v < graph.getVertices(); v++) {
                if (dfs.visited(v))
                    pc.add(v);
            }
        }

        for (int v : pc)
            if (v == M)
                return true;
        return false;
    }
}
