package org.alg.advanced.graph.undirected.represent;

import org.alg.fundamentals.impl.symboltable.ST;

import java.util.Scanner;

/**
 * Define graph with String vertex names instead of integer indices
 */
public class SymbolGraph {

    private ST<String, Integer> st;
    private String[] keys;
    private Graph graph;

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        Scanner scanner = new Scanner(stream);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(sp);
            for (int i = 0; i < line.length; i++) {
                if (!st.contains(line[i])) {
                    st.put(line[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        scanner.close();
        graph = new Graph(st.size());
        scanner = new Scanner(stream);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(sp);
            int v = st.get(line[0]);
            for (int i = 0; i < line.length; i++) {
                graph.addEdge(v, st.get(line[i]));
            }
        }
        scanner.close();
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph graph() {
        return graph;
    }
}
