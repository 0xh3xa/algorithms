package org.alg.fundamentals.sort;

public final class QuickSort3Way {

    private QuickSort3Way() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public static <Item extends Comparable<Item>> void sort(Item[] arr) {
        KnuthShuffleSort.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static <Item extends Comparable<Item>> void sort(Item[] arr, int lo, int hi) {
        if (hi <= lo)
            return;
        int lt = lo, gt = hi;
        Item v = arr[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0)
                swap(arr, lt++, i++);
            else if (cmp > 0)
                swap(arr, i, gt--);
            else
                i++;
        }
        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    private static <Item extends Comparable<Item>> void swap(Item[] arr, int firstIndex, int secondIndex) {
        Item temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
