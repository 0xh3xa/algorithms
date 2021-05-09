package org.alg.advanced.string.sort;

import java.util.Arrays;

/**
 * class represents the key indexed counting sort algorithm
 */
public final class KeyIndexedCounting {

    private static final int R = 256; // ASCII chars 2^8

    private KeyIndexedCounting() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static void sort(char[] a) {
        int N = a.length;

        char[] aux = new char[N];
        int[] count = new int[R + 1];

        for (int i = 0; i < N; i++)
            count[a[i] + 1]++; // count frequencies offset by 1

        for (int r = 0; r < R; r++)
            count[r + 1] += count[r]; // compute cumulates offset by 1

        for (int i = 0; i < N; i++)
            aux[count[a[i]]++] = a[i]; // move items and increment index for next slot for the same char

        for (int i = 0; i < N; i++)
            a[i] = aux[i]; // copy back
    }
}