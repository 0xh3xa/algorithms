package org.alg.advanced.string.search;

/**
 * class represent ternary trie
 */
public class TernaryST<Value> {

    private class Node {
        Value val;
        char c;
        Node left, mid, right;
    }

    private Node root;

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node node, String key, Value val, int d) {
        char c = key.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c)
            node.left = put(node.left, key, val, d);
        else if (c > node.c)
            node.right = put(node.right, key, val, d);
        else if (d < key.length() - 1)
            node.mid = put(node.mid, key, val, d + 1);
        else
            node.val = val;
        return node;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null)
            return null;
        return node.val;
    }

    private Node get(Node node, String key, int d) {
        if (node == null)
            return null;
        char c = key.charAt(d);
        if (c < node.c)
            return get(node.left, key, d);
        else if (c > node.c)
            return get(node.right, key, d);
        else if (d < key.length() - 1)
            return get(node.mid, key, d + 1);
        else
            return node;
    }
}
