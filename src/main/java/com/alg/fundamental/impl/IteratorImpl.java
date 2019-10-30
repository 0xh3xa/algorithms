package com.alg.fundamental.impl;

import com.alg.fundamental.base.NodeBase;
import java.util.Iterator;

public class IteratorImpl<Item> extends NodeBase<Item> implements Iterator<Item> {

    private NodeBase<Item> current;

    public IteratorImpl(NodeBase first) {
        current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Item next() {
        Item result = current.item;
        current = current.next;
        return result;
    }

    @Override
    protected Iterator<Item> getIterator() {
        return null;
    }
}
