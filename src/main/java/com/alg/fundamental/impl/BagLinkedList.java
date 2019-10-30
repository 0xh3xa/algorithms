package com.alg.fundamental.impl;

import com.alg.fundamental.base.IBag;
import com.alg.fundamental.base.NodeBase;
import java.util.Iterator;

public class BagLinkedList<Item> extends NodeBase<Item> implements IBag<Item> {

    private NodeBase<Item> first;
    private int pos;

    private class Node extends NodeBase {

        @Override
        protected Iterator getIterator() {
            return iterator();
        }
    }

    @Override
    public void add(Item item) {
        NodeBase oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        pos++;
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
    public Iterator<Item> iterator() {
        return new IteratorImpl<>(first);
    }

    @Override
    protected Iterator<Item> getIterator() {
        return iterator();
    }
}
