package org.alg.advanced.string.sort;

public final class MSD {

    private MSD() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private final static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (hi <= lo)
            return;
        int R = 256;
        int[] count = new int[R + 1];
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1); // sort R subarrays recursively
    }

    private final static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }
}