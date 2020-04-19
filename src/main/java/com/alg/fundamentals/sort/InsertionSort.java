package com.alg.fundamentals.sort;

import java.util.Comparator;

public final class InsertionSort {

    private InsertionSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static <Item extends Comparable<Item>> void sort(Item[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public final static void sort(Object[] arr, Comparator comparator) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(comparator, arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public final static void sort(Object[] arr, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && less(comparator, arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public final static <Item extends Comparable<Item>> void sort(Item[] arr, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static <Item extends Comparable<Item>> boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    private static <Item extends Comparable<Item>> void swap(Item[] arr, int firstIndex, int secondIndex) {
        Item temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
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
