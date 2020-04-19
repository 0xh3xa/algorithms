package com.alg.fundamentals.sort;

public final class HeapSort<Item extends Comparable<Item>> {

    private HeapSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static <Item extends Comparable<Item>> void sort(Item[] pq) {
        int n = pq.length;

        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        int k = n;
        while (k > 1) {
            swap(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    // Get the largest and put as a parent
    private static <Item extends Comparable<Item>> void sink(Item[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1))
                j++;
            if (!less(pq, k, j)) // K less than children then break
                break;
            swap(pq, k, j);
            k = j;
        }
    }

    private static <Item extends Comparable<Item>> boolean less(Item[] pq, int firstIndex, int secondIndex) {
        return pq[firstIndex - 1].compareTo(pq[secondIndex - 1]) < 0;
    }

    private static <Item extends Comparable<Item>> void swap(Item[] pq, int firstIndex, int secondIndex) {
        Item temp = pq[firstIndex - 1];
        pq[firstIndex - 1] = pq[secondIndex - 1];
        pq[secondIndex - 1] = temp;
    }
}
