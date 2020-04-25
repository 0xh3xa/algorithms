package org.alg.advanced.directed.processing;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;

import org.alg.BaseTest;
import org.alg.advanced.graph.directed.processing.Topological;
import org.alg.advanced.graph.directed.represent.SymbolDigraph;

import org.junit.Before;
import org.junit.Test;

public class TopologicalTest extends BaseTest {

    private static final String FILE_NAME = "src/test/resources/topological/jobs";

    private SymbolDigraph symbolDigraph;

    @Before
    public void setUp() throws Exception {
        symbolDigraph = new SymbolDigraph(FILE_NAME, "/");
    }

    @Test
    public void shouldOrder() {
        // Arrange
        final List<String> result = new ArrayList<>();
        result.add("Calculus");
        result.add("Linear Algebra");
        result.add("Introduction to CS");
        result.add("Advanced Programming");
        result.add("Algorithms");
        result.add("Theoretical CS");
        result.add("Artificial Intelligence");
        result.add("Robotics");
        result.add("Machine Learning");
        result.add("Neural Networks");
        result.add("Databases");
        result.add("Scientific Computing");
        result.add("Computational Biology");

        // Act
        Topological topological = new Topological(symbolDigraph.graph());

        // Assert
        int i = 0;
        while (!topological.order().isEmpty()) {
            collector.checkThat(symbolDigraph.name(topological.order().pop()), equalTo(result.get(i++)));
        }
    }
}
