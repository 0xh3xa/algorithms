package org.alg.advanced.string.sort;

public final class KeyIndexedCounting {

    private KeyIndexedCounting() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static void sort(char[] a) {
        int N = a.length;
        int R = 256;
        int[] count = new int[R + 1];
        char[] aux = new char[N];
        for (int i = 0; i < N; i++)
            count[a[i] + 1]++; // count frequencies offset by 1

        for (int r = 0; r < R; r++)
            count[r + 1] += count[r]; // compute cumulates

        for (int i = 0; i < N; i++)
            aux[count[a[i]]++] = a[i]; // move items

        for (int i = 0; i < N; i++)
            a[i] = aux[i]; // copy back
    }
}