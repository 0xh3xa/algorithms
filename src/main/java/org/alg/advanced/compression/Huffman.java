package org.alg.advanced.compression;

/**
 * Huffman compression algorithm implementation
 */
public class Huffman {

    private static class Node implements Comparable<Node> {

        private final Node left, right;
        private char ch; // Unused for internal nodes
        private int freq; // Unused for expand

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public void expand(String file) {
            // Node root = readTrie();
            // int N = 
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node other) {
            return this.freq = other.freq;
        }
    }
}