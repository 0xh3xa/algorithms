package com.alg.fundamental.base;

public interface IStack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    boolean isEmpty();
}
