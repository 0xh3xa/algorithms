package org.alg.fundamentals.base;

public interface IPriorityQueue<Item extends Comparable<Item>> {

    void insert(Item key);

    boolean isEmpty();

    int size();
}
