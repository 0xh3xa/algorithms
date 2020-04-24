package com.alg.advanced.graph.directed.represent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.alg.fundamentals.impl.st.ST;

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
            String[] lines = line.split(sp);
            for (int i = 0; i < lines.length; i++) {
                if (!st.contains(lines[i])) {
                    st.put(lines[i], st.size());
                }
            }
        });

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        graph = new Digraph(st.size());

        Files.lines(new File(path).toPath()).forEach(line -> {
            String[] lines = line.split(sp);
            int v = st.get(lines[0]);
            for (int i = 0; i < lines.length; i++) {
                graph.addEdge(v, st.get(lines[i]));
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