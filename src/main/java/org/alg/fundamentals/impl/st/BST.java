package org.alg.fundamentals.impl.st;

import org.alg.fundamentals.base.SymbolTable;

public class BST<Key extends Comparable, Value> implements SymbolTable<Key, Value> {

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;
    private int size = 0;

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
        size++;
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;
        return node;
    }

    @Override
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.val;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        // size--;
        // root = delete(root, key);
    }

    // private Node delete(Node node, Key key) {
    // if (node == null)
    // return null;
    // int cmp = key.compareTo(node.key);
    // if (cmp < 0)
    // node.left = delete(node.left, key);
    // else if (cmp > 0)
    // node.right = delete(node.right, key);
    // else {
    // if (node.right == null)
    // return node.left;
    // if (node.left == null)
    // return node.right;
    // Node t = x;
    // x = min(t.right);
    // node.right = deleteMin(t.right);
    // node.left = t.left;
    // }
    // node.count = size(node.left) + size(node.right) + 1;
    // return node;
    // }

    @Override
    public boolean contains(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        return null;
    }

}