package org.alg.fundamentals.impl.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.alg.fundamentals.base.Queue;

public class LinkedQueue<Item> implements Queue<Item> {

    private class NodeList {

        Item item;
        NodeList next;

        public NodeList(Item item) {
            this.item = item;
        }
    }

    private NodeList first;
    private NodeList last;
    private int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void enqueue(Item item) {
        NodeList oldLast = last;
        last = new NodeList(item);
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator<Item> {

        NodeList head = first;

        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        @Override
        public Item next() {
            Item item = head.item;
            head = head.next;
            return item;
        }
    }
}
