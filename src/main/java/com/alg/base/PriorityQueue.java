package com.alg.base;

public interface PriorityQueue<Item> {

    void insert(Item key);

    Item delMax();

    boolean isEmpty();

    Item max();

    int size();
}