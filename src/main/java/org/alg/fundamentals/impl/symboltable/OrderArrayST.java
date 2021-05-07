package org.alg.fundamentals.impl.symboltable;

import org.alg.fundamentals.base.SymbolTable;

import java.util.Iterator;

public class OrderArrayST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public OrderArrayST(int cap) {
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
        N = 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("key must not be null");

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            if (val != null) {
                values[i] = val;
            } else {
                delete(key);
                N--;
            }
            return;
        }

        // inserts a new key-value pair
        keys[N] = key;
        values[N] = val;
        shift(i, N);
        N++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return values[i];
        return null;
    }

    @Override
    public void delete(Key key) {
        int index = rank(key);
        if (index >= 0 && keys[index].compareTo(key) == 0) {
            keys[index] = null;
            values[index] = null;
            N--;
        }
    }

    private void shift(int lo, int hi) {
        while (keys[lo].compareTo(keys[hi]) > 0) {
            swap(keys, lo, hi);
            swap(values, lo, hi);
            lo++;
        }
    }

    @Override
    public boolean contains(Key key) {
        int index = rank(key);
        if (index >= 0 && keys[index].compareTo(key) == 0)
            return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    private int i = 0;
                    private int size = keys.length;

                    @Override
                    public boolean hasNext() {
                        return i < size;
                    }

                    @Override
                    public Key next() {
                        return keys[i++];
                    }
                };
            }
        };
    }

    private int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }
}