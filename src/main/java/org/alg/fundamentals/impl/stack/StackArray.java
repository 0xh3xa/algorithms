package org.alg.fundamentals.impl.stack;

import org.alg.fundamentals.base.Stack;

public class StackArray<Item> implements Stack<Item> {

    private Item[] arr = (Item[]) new Object[4];
    private int ptr = 0;

    @Override
    public void push(Item item) {
        if (arr.length >= ptr)
            resize(arr.length * 2);
        arr[ptr++] = item;
    }

    @Override
    public Item pop() {
        try {
            Item item = arr[--ptr];
            arr[ptr] = null;
            if (ptr > 0 && ptr == arr.length / 4)
                resize(arr.length / 2);
            return item;
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    @Override
    public boolean isEmpty() {
        return ptr == 0;
    }

    @Override
    public int size() {
        return ptr;
    }

    private void resize(int newSize) {
        Item[] newArr = (Item[]) new Object[newSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

}