package com.alg.sort.impl;

import java.util.Comparator;

public class MergeSort {

    private static final int CUTOFF = 7;

    private MergeSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    /**
     * Merge sort recursive version
     */
    public static <Item extends Comparable<Item>> void sort(Item[] arr, Item[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        if (hi <= lo + CUTOFF) {
            InsertionSort.sort(arr, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        if (!less(arr[mid + 1], arr[mid]))
            return;
        merge(arr, aux, lo, mid, hi);
    }

    /**
     * Mergesort Bottom up version
     */
    public static <Item extends Comparable<Item>> void sortBottomUp(Item[] arr) {
        int N = arr.length, hi;
        Item[] aux = (Item[]) new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                hi = Math.min(lo + sz + sz - 1, N - 1);
                if (hi <= lo + CUTOFF - 1)
                    InsertionSort.sort(arr, lo, hi);
                else
                    mergeCopyAux(arr, aux, lo, lo + sz - 1, hi);
            }
    }

    /**
     * Merge sort recursive with Comparator version
     */
    public static void sort(Object[] arr, Object[] aux, int lo, int hi, Comparator comparator) {
        if (hi <= lo)
            return;
        if (hi <= lo + CUTOFF - 1) {
            InsertionSort.sort(arr, lo, hi, comparator);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid, comparator);
        sort(arr, aux, mid + 1, hi, comparator);
        if (!less(comparator, arr[mid + 1], arr[mid]))
            return;
        merge(arr, aux, lo, mid, hi, comparator);
    }

    /**
     * Merge method for recursive version
     */
    private static <Item extends Comparable<Item>> void merge(Item[] arr, Item[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                aux[k] = arr[j++];
            else if (j > hi)
                aux[k] = arr[i++];
            else if (less(arr[j], arr[i]))
                aux[k] = arr[j++];
            else
                aux[k] = arr[i++];
        }
    }

    /**
     * Merge method for bottom up version
     */
    private static <Item extends Comparable<Item>> void mergeCopyAux(Item[] arr, Item[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > hi)
                arr[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
        }
    }

    /**
     * Merge method for Comparator version
     */
    private static void merge(Object[] arr, Object[] aux, int lo, int mid, int hi, Comparator comparator) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                aux[k] = arr[j++];
            else if (j > hi)
                aux[k] = arr[i++];
            else if (less(comparator, arr[j], arr[i]))
                aux[k] = arr[j++];
            else
                aux[k] = arr[i++];
        }
    }

    private static <Item extends Comparable<Item>> boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    private static boolean less(Comparator comparator, Object o1, Object o2) {
        return comparator.compare(o1, o2) < 0;
    }

    private static void swap(Object[] arr, int firstIndex, int secondIndex) {
        Object temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}