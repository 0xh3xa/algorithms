package com.alg.fundamental.excersises;

import com.alg.fundamental.impl.StackArray;

public class BinaryRepresentation {

    public static String getBinary(int number) {
        StackArray<Integer> stack = new StackArray<>();
        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }
        return stack.toString();
    }
}
