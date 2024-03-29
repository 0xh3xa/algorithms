package org.alg.advanced.string.sort;

public final class MSDQuickSort {

    private MSDQuickSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private final static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo)
            return;
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v)
                swap(a, lt++, i++);
            else if (t > v)
                swap(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }

    private final static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}