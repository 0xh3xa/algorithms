package org.alg.advanced.string.search;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * class represents R-way trie implementation for string search
 */
public class TrieST<Value> {

    // Extended ASCII
    // Could be 26 if you sure that strings consists english letter only
    // and index of character will be node.next[ch - 'a']
    private final static int R = 256;

    private class Node {
        private Object val;
        private Node[] next = (Node[]) new Object[R];
    }

    private int size;
    private Node root;

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node node, String key, Value val, int d) {
        if (node == null) {
            node = new Node();
        }
        if (d == key.length()) {
            size++;
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

    /**
     * Get all keys in the tries
     * 
     * @return Iterable<String>
     */
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

    /**
     * Get all keys with prefix in the tries
     * 
     * @return Iterable<String>
     */
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new ArrayDeque<>();
        Node node = get(root, prefix, 0);
        collect(node, prefix, queue);
        return queue;
    }

    /**
     * Get longest prefix matches query exist in trie
     * 
     * @return String
     */
    public String longestPrefixOf(String query) {
        int length = search(root, query, 0, -1);
        if (length == -1)
            return null;
        return query.substring(0, length);
    }

    /**
     * Get boolean if trie contains string start with prefix
     * 
     * @return boolean
     */
    public boolean startsWith(String prefix) {
        return get(root, prefix, 0) != null;
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node node, String key, int d) {
        if (node == null)
            return null;
        if (d == key.length()) { // hit the key length
            if (node.val != null)
                size--;
            node.val = null;
        } else { // go next
            char c = key.charAt(d);
            node.next[c] = delete(node.next[c], key, d + 1);
        }

        // check subtree if value is not null then return node
        if (node.val != null)
            return node;

        // node value is null check all links, if all links are null return null
        // otherwise return first not null value node
        for (int c = 0; c < R; c++)
            if (node.next[c] != null)
                return node;
        return null;
    }
}
