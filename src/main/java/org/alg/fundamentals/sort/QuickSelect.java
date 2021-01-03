package org.alg.fundamentals.sort;

public final class QuickSelect {

    private QuickSelect() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    public static <Item extends Comparable<Item>> Comparable<Item> select(Item[] arr, int k) {
        KnuthShuffleSort.shuffle(arr);
        int lo = 0, hi = arr.length - 1;
        while (hi > lo) {
            int j = partition(arr, lo, hi);
            if (j < k)
                lo = j + 1;
            else if (j > k)
                hi = j - 1;
            else
                return arr[k];
        }
        return arr[k];
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
        return item1.compareTo(item2) < 0;
    }

    private static <Item extends Comparable<Item>> void swap(Item[] arr, int firstIndex, int secondIndex) {
        Item temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
