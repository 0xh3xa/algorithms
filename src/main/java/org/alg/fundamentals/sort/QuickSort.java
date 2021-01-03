package org.alg.fundamentals.sort;

public final class QuickSort {

    private static final int CUTOFF = 8;

    private QuickSort() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        KnuthShuffleSort.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static <Item extends Comparable<Item>> void sort(Item[] arr, int lo, int hi) {
        if (hi <= lo)
            return;
        int n = hi - lo + 1;

        if (n <= CUTOFF) {
            InsertionSort.sort(arr, lo, hi);
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static <Item extends Comparable<Item>> int partition(Item[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(arr[++i], arr[lo]))
                if (i == hi)
                    break;
            while (less(arr[lo], arr[--j]))
                ;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private static <Item extends Comparable<Item>> boolean less(Item item1, Item item2) {
        if (item1 == item2)
            return false; // optimization when reference equals
        return item1.compareTo(item2) < 0;
    }

    private static <Item extends Comparable<Item>> void swap(Item[] arr, int firstIndex, int secondIndex) {
        Item temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
