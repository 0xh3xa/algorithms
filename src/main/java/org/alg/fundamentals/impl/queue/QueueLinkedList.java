package org.alg.fundamentals.impl.queue;

import org.alg.fundamentals.base.Queue;

public class QueueLinkedList<Item> implements Queue<Item> {

    private class NodeList {
        Item item;
        NodeList next;

        public NodeList(Item item) {
            this.item = item;
        }
    }

    private NodeList first = null, last = null;
    private int size = 0;

    @Override
    public void enqueue(Item item) {
        NodeList oldLast = last;
        last = new NodeList(item);
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        size++;
    }

    @Override
    public Item dequeue() {
        try {
            Item item = first.item;
            first = first.next;
            if (isEmpty())
                last = null;
            size--;
            return item;
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

}