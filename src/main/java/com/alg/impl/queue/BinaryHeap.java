package com.alg.impl.queue;

import com.alg.base.PriorityQueue;

public class BinaryHeap<Item extends Comparable<Item>> implements PriorityQueue<Item> {

    private Item[] pq;
    private int N;

    public BinaryHeap(int cap) {
        pq = (Item[]) new Object[cap + 1];
        N = 0;
    }

    @Override
    public void insert(Item key) {
        pq[++N] = key;
        swim(N);
    }

    @Override
    public Item delMax() {
        Item max = pq[1];
        swap(1, N--);
        sink(1);
        pq[N + 1] = null; // prevent loitering, object no longer needed
        return max;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Item max() {
        return pq[1];
    }

    @Override
    public int size() {
        return pq.length - 1;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j - 1))
                j++;
            if (!greater(k, j)) // K greater than children then break
                break;
            swap(k, j);
            k = j;
        }
    }

    private boolean greater(int firstIndex, int secondIndex) {
        return pq[firstIndex].compareTo(pq[secondIndex]) > 0;
    }

    private void swap(int firstIndex, int secondIndex) {
        Item temp = pq[firstIndex];
        pq[firstIndex] = pq[secondIndex];
        pq[secondIndex] = temp;
    }
}