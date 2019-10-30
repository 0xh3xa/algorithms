package com.alg.fundamental.impl;

import com.alg.fundamental.base.IQueue;
import com.alg.fundamental.base.NodeBase;
import java.util.Iterator;

public class QueueLinkedList<Item> extends NodeBase<Item> implements IQueue<Item> {

    private NodeBase<Item> first;
    private NodeBase<Item> last;
    private int pos;

    private class Node extends NodeBase {

        @Override
        protected Iterator getIterator() {
            return iterator();
        }
    }

    @Override
    public void enqueue(Item item) {
        NodeBase oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        pos++;
    }

    @Override
    public Item dequeue() {
        Item result = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        pos--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return pos;
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl(first);
    }

    @Override
    protected Iterator<Item> getIterator() {
        return iterator();
    }
}
