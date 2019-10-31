package com.alg.fundamental.excersises;

import com.alg.fundamental.impl.StackArray;

public class StackArrayCopyString<Item> extends StackArray<Item> {

    public static <Item> StackArray<Item> copy(StackArray<Item> stack) {
        StackArray<Item> newStack = new StackArray<>();
        StackArray<Item> tempStack = new StackArray<>();
        for (Item item : stack) {
            tempStack.push(item);
        }
        while (!tempStack.isEmpty()) {
            newStack.push(tempStack.pop());
        }
        return newStack;
    }
}
