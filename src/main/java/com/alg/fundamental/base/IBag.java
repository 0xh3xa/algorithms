package com.alg.fundamental.base;

public interface IBag<Item> extends Iterable<Item> {

    void add(Item item);

    boolean isEmpty();

    int size();
}
