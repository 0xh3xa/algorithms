package org.alg.advanced.string.sort;

/**
 * class represents Least significant digit string sorting for fixed key length
 */
public final class LSD {

    private static final int R = 256;

    private LSD() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public static void sort(String[] a, int W) {
        int N = a.length;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) { // do key-indexed counting for each digit from right to left
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++; // key-indexed counting
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}