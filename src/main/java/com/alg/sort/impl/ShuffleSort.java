package com.alg.sort.impl;

import java.util.Random;

public class ShuffleSort {

    private ShuffleSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public static <Item extends Comparable<Item>> void shuffle(Item[] arr) {
        int N = arr.length;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int r = random.nextInt(i + 1);
            swap(arr, i, r);
        }
    }

    private static <Item extends Comparable<Item>> void swap(Item[] arr, int firstIndex, int secondIndex) {
        Item temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}