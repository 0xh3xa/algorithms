package org.alg.fundamentals.impl.queue.priority;

import org.alg.fundamentals.base.IMaxPQ;

/**
 * Class representation to Priority Queue for fast insert O(1) and delete max
 * with time complexity O(N)
 */
public class UnorderedArrayMaxPQ<Item extends Comparable<Item>> implements IMaxPQ<Item> {

    private Item[] pq;
    private int pos;

    public UnorderedArrayMaxPQ(int capacity) {
        pq = (Item[]) new Comparable[capacity];
        pos = 0;
    }

    @Override
    public void insert(Item key) {
        pq[pos++] = key;
    }

    @Override
    public Item delMax() {
        int max = 0;
        for (int i = 0; i < pos; i++) {
            if (less(max, i))
                max = i;
        }
        swap(max, pos - 1);
        Item item = pq[--pos];
        pq[pos] = null;
        return item;
    }

    private void swap(int max, int i) {
        Item swap = pq[i];
        pq[i] = pq[max];
        pq[max] = swap;
    }

    private boolean less(int max, int i) {
        return pq[max].compareTo(pq[i]) < 0;
    }

    @Override
    public boolean isEmpty() {
        return pos < 0;
    }

    @Override
    public Item max() {
        return delMax();
    }

    @Override
    public int size() {
        return pos;
    }
}
