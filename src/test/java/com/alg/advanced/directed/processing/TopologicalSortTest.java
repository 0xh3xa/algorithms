package com.alg.advanced.directed.processing;

import java.io.FileNotFoundException;

import com.alg.advanced.graph.directed.processing.TopologicalSort;
import com.alg.advanced.graph.directed.represent.SymbolDigraph;

import org.junit.Before;
import org.junit.Test;

public class TopologicalSortTest {

    private static final String FILE_NAME = "/Users/ninja/Documents/topological_sort";

    private SymbolDigraph symbolDigraph;

    @Before
    public void setUp() throws Exception {
        symbolDigraph = new SymbolDigraph(FILE_NAME, "/");
    }

    @Test
    public void shouldOrder() {
        // Act
        TopologicalSort sort = new TopologicalSort(symbolDigraph.graph());

        // Assert
        for (int v : sort.order()) {
            System.out.println(symbolDigraph.name(v));
        }
    }
}