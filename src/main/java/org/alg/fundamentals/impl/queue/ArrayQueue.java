package org.alg.fundamentals.impl.queue;

import org.alg.fundamentals.base.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<Item> implements Queue<Item> {

    private Item[] q;
    private int first;
    private int last;
    private int size;

    public ArrayQueue() {
        q = (Item[]) new Object[2];
        size = 0;
        first = 0;
        last = 0;
    }

    @Override
    public void enqueue(Item item) {
        if (size == q.length) {
            resize(q.length * 2);
        }
        q[last++] = item;
        if (last == q.length) {
            last = 0;
        }
        size++;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = q[first];
        q[first] = null;
        size--;
        first++;
        if (first == q.length) {
            first = 0;
        }
        if (size > 0 && size == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return q[first];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int newSize) {
        Item[] newArr = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArr[i] = q[(first + i) % q.length];
        }
        q = newArr;
        last = size;
        first = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator<Item> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i <= size;
        }

        @Override
        public Item next() {
            return q[i++];
        }

    }
}
