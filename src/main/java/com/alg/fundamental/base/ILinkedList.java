package com.alg.fundamental.base;

import java.util.Comparator;

public interface ILinkedList<Item> extends Iterable<Item> {

    void add(Item item);

    Item remove();

    Item remove(Item obj);

    Item removeAll(Item obj);

    boolean isEmpty();

    Item max(Comparator<Item> comparator);

    Item maxRecursive(Comparator<Item> comparator);

    Item min(Comparator<Item> comparator);

    int size();
}
