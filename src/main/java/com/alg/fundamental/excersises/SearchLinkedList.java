package com.alg.fundamental.excersises;

import com.alg.fundamental.impl.QueueLinkedList;

public class SearchLinkedList<Item> {

    public static <Item> boolean hasItem(Item key, QueueLinkedList<Item> queue) {
        for (Item item : queue) {
            if (item != null && item.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
