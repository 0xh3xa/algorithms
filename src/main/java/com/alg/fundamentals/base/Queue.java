package com.alg.fundamentals.base;

public interface Queue<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}