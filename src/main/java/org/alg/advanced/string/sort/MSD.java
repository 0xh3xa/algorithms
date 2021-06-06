package org.alg.advanced.string.sort;

import java.util.Arrays;

/**
 * class represents Most significant digit string sorting with variable string
 * length
 */
public final class MSD {

    private static final int R = 256;
    private static final int CUTOFF = 15;

    private MSD() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private final static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2]; // two for offset 1 and char '\0'
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c + 2]++; // offset by 1 and one for char '\0'
        }

        // transform counts to indices
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r]; // offset by 1

        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++) {
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1); // sort R subarrays recursively
        }
    }

    private final static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    private static void insertionSort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i))
                return true;
            if (v.charAt(i) > w.charAt(i))
                return false;
        }
        return v.length() < w.length();
    }
}
