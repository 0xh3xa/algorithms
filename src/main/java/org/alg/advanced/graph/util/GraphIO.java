package org.alg.advanced.graph.util;

import org.alg.advanced.graph.directed.represent.Digraph;
import org.alg.advanced.graph.undirected.represent.Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Util class for reading graph from file
 */
public final class GraphIO {

    private GraphIO() {
        throw new UnsupportedOperationException();
    }

    private final static List<String> readLines(final Path filePath) throws IOException {
        return Files.readAllLines(filePath);
    }

    public final static Graph buildBiGraphFromFile(final Path filePath) throws IOException {
        List<String> lines = readLines(filePath);
        int vertices = Integer.parseInt(lines.get(0));
        Graph graph = new Graph(vertices);
        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(" ");
            graph.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        return graph;
    }

    public final static Digraph buildDiGraphFromFile(final Path filePath) throws IOException {
        List<String> lines = readLines(filePath);
        int vertices = Integer.parseInt(lines.get(0));
        Digraph graph = new Digraph(vertices);
        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(" ");
            graph.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        return graph;
    }
}