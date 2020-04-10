package com.alg.base;

public interface Queue<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}