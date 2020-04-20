package com.alg.advanced;

import com.alg.advanced.graph.DepthFirstSearch;
import com.alg.advanced.graph.Graph;

import org.junit.Before;
import org.junit.Test;

public class DepthFirstSearchTest extends GraphBaseTest {

    private DepthFirstSearch dfs;
    private Graph graph;

    @Before
    public void setUp() {
        graph = createDFSGraph();
        dfs = new DepthFirstSearch(graph, 0);
    }

    @Test
    public void shouldConnect(){
        // Arrange

        // Act

        // Assert
    }
}