package com.alg.sort.impl;

public final class KnuthShuffleSort {

    private KnuthShuffleSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public final static <Item extends Comparable<Item>> void shuffle(Item[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int r = (int) Math.random() * (i + 1);
            swap(arr, i, r);
        }
    }

    private static <Item extends Comparable<Item>> void swap(Item[] arr, int firstIndex, int secondIndex) {
        Item temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}