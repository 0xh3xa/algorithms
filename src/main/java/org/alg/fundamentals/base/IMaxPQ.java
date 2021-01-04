package org.alg.fundamentals.base;

public interface IMaxPQ<Item extends Comparable<Item>> extends IPriorityQueue<Item> {

    Item delMax();

    Item max();
}
