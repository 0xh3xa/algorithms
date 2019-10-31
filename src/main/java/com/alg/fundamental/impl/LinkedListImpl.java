package com.alg.fundamental.impl;

import com.alg.fundamental.base.ILinkedList;
import com.alg.fundamental.base.NodeBase;
import java.util.Comparator;
import java.util.Iterator;

public class LinkedListImpl<Item> extends NodeBase<Item> implements ILinkedList<Item> {

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
    public void add(Item item) {
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
    public Item remove() {
        Item result = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        pos--;
        return result;
    }

    @Override
    public Item remove(Item obj) {
        NodeBase prev = first;
        for (NodeBase node = first; node != null; node = node.next) {
            if (node.item != null && node.item.equals(obj)) {
                if (node == first) {
                    first = node.next;
                } else {
                    prev.next = node.next;
                }
                pos--;
                return (Item) node.item;
            }
            prev = node;
        }
        return null;
    }

    @Override
    public Item removeAll(Item obj) {
        NodeBase prev = first;
        for (NodeBase node = first; node != null; node = node.next) {
            if (node.item != null && node.item.equals(obj)) {
                if (node == first) {
                    first = node.next;
                } else {
                    prev.next = node.next;
                }
                pos--;
            }
            prev = node;
        }
        return obj;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Item max(Comparator comparator) {
        if (isEmpty()) {
            return null;
        }
        Item max = first.item;
        for (NodeBase<Item> node = first.next; node != null; node = node.next) {
            int cmp = comparator.compare(max, node.item);
            if (cmp < 0) {
                max = node.item;
            }
        }
        return max;
    }

    @Override
    public Item maxRecursive(Comparator<Item> comparator) {
        if (isEmpty()) {
            return null;
        }
        Item max = first.item;
        return doRecursive(first.next, comparator, max);
    }

    private Item doRecursive(NodeBase<Item> node, Comparator<Item> comparator, Item max) {
        if (node == null) {
            return max;
        }
        int cmp = comparator.compare(max, node.item);
        if (cmp < 0) {
            max = node.item;
        }
        return doRecursive(node.next, comparator, max);
    }

    @Override
    public Item min(Comparator comparator) {
        if (isEmpty()) {
            return null;
        }
        Item min = first.item;
        for (NodeBase<Item> node = first.next; node != null; node = node.next) {
            int cmp = comparator.compare(min, node.item);
            if (cmp > 0) {
                min = node.item;
            }
        }
        return min;
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
