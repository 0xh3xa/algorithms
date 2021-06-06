package org.alg.fundamentals.base;

public interface IMinPQ<Item extends Comparable<Item>> extends IPriorityQueue<Item> {

    Item delMin();

    Item min();
}
