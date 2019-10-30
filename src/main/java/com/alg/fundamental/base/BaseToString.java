package com.alg.fundamental.base;

import java.util.Iterator;

public abstract class BaseToString<Item> {

    protected abstract Iterator<Item> getIterator();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Item> iterator = getIterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next() + " ");
        }
        return builder.toString();
    }
}
