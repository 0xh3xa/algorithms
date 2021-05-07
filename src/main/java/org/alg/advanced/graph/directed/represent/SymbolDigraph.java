package org.alg.advanced.graph.directed.represent;

import org.alg.fundamentals.impl.symboltable.ST;

import java.io.File;
import java.nio.file.Files;

/**
 * Define graph with String vertex na˝mes instead of integer indices
 */
public class SymbolDigraph {

    private ST<String, Integer> st;
    private String[] keys;
    private Digraph graph;

    public SymbolDigraph(String path, String sp) throws Exception {
        st = new ST<>();
        Files.lines(new File(path).toPath()).forEach(line -> {
            String[] split = line.split(sp);
            for (int i = 0; i < split.length; i++) {
                if (!st.contains(split[i])) {
                    st.put(split[i], st.size());
                }
            }
        });

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        graph = new Digraph(st.size());
        Files.lines(new File(path).toPath()).forEach(line -> {
            String[] split = line.split(sp);
            int v = st.get(split[0]);
            for (int i = 1; i < split.length; i++) {
                graph.addEdge(v, st.get(split[i]));
            }
        });

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

    public Digraph graph() {
        return graph;
    }
}
