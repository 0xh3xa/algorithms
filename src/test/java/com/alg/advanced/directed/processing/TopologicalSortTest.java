package com.alg.advanced.directed.processing;

import com.alg.advanced.graph.directed.processing.TopologicalSort;
import com.alg.advanced.graph.directed.represent.SymbolDigraph;

import org.junit.Before;
import org.junit.Test;

public class TopologicalSortTest {

    private static final String FILE_NAME = "C:\\Users\\space\\Desktop\\jobs.txt";

    private SymbolDigraph symbolDigraph;

    @Before
    public void setUp() throws Exception {
        symbolDigraph = new SymbolDigraph(FILE_NAME, "/");
    }

    @Test
    public void shouldOrder() {
        // Act
        TopologicalSort topological = new TopologicalSort(symbolDigraph.graph());

        // Assert
        for (int v : topological.order()) {
            System.out.println(symbolDigraph.name(v));
        }
    }
}