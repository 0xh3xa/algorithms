package org.alg.fundamentals.impl.stack;

import org.alg.fundamentals.base.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Stack<Item> {

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
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            NodeList head = first;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public Item next() {
                NodeList oldHead = head;
                Item item = oldHead.item;
                oldHead = null;
                head = head.next;
                return item;
            }
        };
    }

    private class NodeList {
        Item item;
        NodeList next;

        public NodeList(Item item) {
            this.item = item;
        }
    }

}
