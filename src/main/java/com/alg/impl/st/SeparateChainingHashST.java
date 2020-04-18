package com.alg.impl.st;

public class SeparateChainingHashST<Key, Value> {

    private int M = 97;
    private Node[] st = new Node[M];

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node n = st[i]; n != null; n = n.next) {
            if (key.equals(n.key)) {
                n.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]);
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node n = st[i]; n != null; n = n.next) {
            if (key.equals(n.key))
                return (Value) n.val;
        }
        return null;
    }
}