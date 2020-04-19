package com.alg.fundamentals.base;

public interface PriorityQueue<Item extends Comparable<Item>> {

    void insert(Item key);

    Item delMax();

    boolean isEmpty();

    Item max();

    int size();
}