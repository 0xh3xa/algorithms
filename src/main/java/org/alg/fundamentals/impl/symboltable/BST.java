package org.alg.fundamentals.impl.symboltable;

import org.alg.fundamentals.base.Queue;
import org.alg.fundamentals.base.SymbolTable;
import org.alg.fundamentals.impl.queue.LinkedQueue;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    private Node root;
    private int size = 0;

    @Override
    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("key must not be null");

        root = put(root, key, val);
        size++;
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;
        node.count = 1 + size(node.left) + size(node.right);
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

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null)
            return null;
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp < 0)
            return floor(node.left, key);

        Node n = floor(node.right, key);
        if (n != null)
            return n;
        else
            return node;
    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null)
            return null;
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp < 0) {
            Node n = ceiling(node.left, key);
            if (n != null)
                return n;
            else
                return n;
        }

        return ceiling(node.right, key);
    }

    @Override
    public void delete(Key key) {
        size--;
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

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
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return node.count;
    }

    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedQueue<>();
        inorder(root, q);
        return q;
    }

    public Iterable<Key> keysMinMax() {
        if (isEmpty())
            return new LinkedQueue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new LinkedQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.enqueue(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    private void inorder(Node node, Queue<Key> q) {
        if (node == null)
            return;
        inorder(node.left, q);
        q.enqueue(node.key);
        inorder(node.right, q);
    }

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;

        public Node(Key key, Value val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }
}
