package org.alg.fundamentals.impl.stack;

import org.alg.fundamentals.base.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<Item> implements Stack<Item> {

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
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        Item item = arr[--ptr];
        arr[ptr] = null;
        if (ptr > 0 && ptr == arr.length / 4)
            resize(arr.length / 2);
        return item;
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

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int i = 0, N = arr.length;

            @Override
            public boolean hasNext() {
                return i < N;
            }

            @Override
            public Item next() {
                return arr[i++];
            }
        };
    }
}
