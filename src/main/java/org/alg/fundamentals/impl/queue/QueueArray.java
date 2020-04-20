package org.alg.fundamentals.impl.queue;

import org.alg.fundamentals.base.Queue;

public class QueueArray<Item> implements Queue<Item> {

    private Item[] arr = (Item[]) new Object[4];
    private int head = -1, tail = -1;
    private int size = 0;

    @Override
    public void enqueue(Item item) {
        arr[++tail] = item;
        size++;
        if (head == -1) {
            head = 0;
        }
        if (size == arr.length)
            resize(arr.length * 2);
    }

    @Override
    public Item dequeue() {
        try {
            if (isEmpty())
                throw new IndexOutOfBoundsException();
            Item item = arr[head];
            arr[head++] = null;
            size--;
            if (size == arr.length / 4)
                resize(arr.length / 2);
            return item;
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }

    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int newSize) {
        Item[] newArr = (Item[]) new Object[newSize];
        for (int i = 0; head <= tail; i++) {
            newArr[i] = arr[head++];
        }
        tail = size - 1;
        head = 0;
        arr = newArr;
    }
}
