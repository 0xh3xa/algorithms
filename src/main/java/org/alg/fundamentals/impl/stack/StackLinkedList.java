package org.alg.fundamentals.impl.stack;

import org.alg.fundamentals.base.Stack;

public class StackLinkedList<Item> implements Stack<Item> {

    private class NodeList {
        Item item;
        NodeList next;

        public NodeList(Item item) {
            this.item = item;
        }
    }

    private NodeList first = null;
    private int size = 0;

    @Override
    public void push(Item item) {
        if (first == null) {
            first = new NodeList(item);
            first.next = null;
        } else {
            NodeList oldFirst = first;
            first = new NodeList(item);
            first.next = oldFirst;
        }
        size++;
    }

    @Override
    public Item pop() {
        try {
            Item item = first.item;
            first = first.next;
            size--;
            return item;
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}