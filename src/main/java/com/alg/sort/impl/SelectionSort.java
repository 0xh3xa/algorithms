package com.alg.sort.impl;

public class SelectionSort {

    private SelectionSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        int N = arr.length;
        int min;
        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(arr, j, min)) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private static <Item extends Comparable<Item>> boolean less(Item[] arr, int firstIndex, int secondIndex) {
        return arr[firstIndex].compareTo(arr[secondIndex]) < 0;
    }

    private static <Item extends Comparable<Item>> void swap(Item[] arr, int firstIndex, int secondIndex) {
        Item temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}