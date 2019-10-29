package com.alg.fundamental.impl;

import com.alg.fundamental.base.IStack;
import java.util.Iterator;

public class MyStack<Item> implements IStack<Item> {

    private int pos = 0;
    private Item[] arr = (Item[]) new Object[1];

    public void push(Item item) {
        if (pos == arr.length) {
            resize(2 * arr.length);
        }
        arr[pos++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < pos; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public Item pop() {
        Item result = arr[--pos];
        arr[pos] = null;
        if (pos > 0 && pos == arr.length / 4) {
            resize(arr.length / 2);
        }
        return result;
    }

    public boolean isEmpty() {
        return pos == 0;
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {

        private int i = pos;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return arr[--i];
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Item item : arr) {
            builder.append(item);
            builder.append("\n");
        }
        return builder.toString();
    }
}
