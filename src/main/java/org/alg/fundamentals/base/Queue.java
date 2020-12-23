package org.alg.fundamentals.base;

public interface Queue<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    Item peek();

    boolean isEmpty();

    int size();
}
