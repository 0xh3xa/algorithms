package org.alg.advanced.string.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringST<Value> {
    private final static int R = 256; // Extended ASCII
    private Node root = new Node();

    private class Node {
        private Object val;
        private Node[] next = (StringST<Value>.Node[]) new Object[R];
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node node, String key, Value val, int d) {
        if (node == null)
            node = new Node();
        if (d == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(d);
        node.next[c] = put(node.next[c], key, val, d + 1);
        return node;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null)
            return null;
        return (Value) node.val;
    }

    private Node get(Node node, String key, int d) {
        if (node == null)
            return null;
        if (d == key.length())
            return node;
        char c = key.charAt(d);
        return get(node.next[c], key, d + 1);
    }

    public Iterable<String> keys() {
        Queue<String> queue = new ArrayDeque<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node node, String prefix, Queue<String> q) {
        if (node == null)
            return;
        if (node.val != null)
            q.add(prefix);
        for (char c = 0; c < R; c++) {
            collect(node.next[c], prefix + c, q);
        }
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new ArrayDeque<>();
        Node node = get(root, prefix, 0);
        collect(node, prefix, queue);
        return queue;
    }

    public String longestPrefixOf(String query) {
        int length = search(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int search(Node node, String query, int d, int length) {
        if (node == null)
            return length;
        if (node.val != null)
            length = d;
        if (d == query.length())
            return length;
        char c = query.charAt(d);
        return search(node.next[c], query, d + 1, length);
    }
}