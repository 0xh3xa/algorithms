package org.alg.fundamentals.impl.st;

public class LinearProbingHashST<Key, Value> {

    private int M = 30001;
    private Value[] vals = (Value[]) new Object[M];
    private Key[] keys = (Key[]) new Object[M];

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key))
                break;
        }
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i]))
                return vals[i];
        }
        return null;
    }
}