package com.alg.fundamental.impl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class MyStackTest {

    private static final double ITEM_ONE = 2.5;
    private static final double ITEM_TWO = 2.5;

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void givenDoubleValuesWhenPushThenPop() {
        // Arrange
        MyStack<Double> stack = new MyStack<>();

        // Act
        stack.push(ITEM_ONE);
        stack.push(ITEM_TWO);

        // Assert
        collector.checkThat(stack.pop(), equalTo(ITEM_ONE));
        collector.checkThat(stack.pop(), equalTo(ITEM_TWO));
        collector.checkThat(stack.isEmpty(), equalTo(true));
    }

    @Test
    public void givenEmptyValuesWhenIsEmptyThenReturnTrue() {
        // Arrange
        MyStack<String> stack = new MyStack<>();

        // Act & Assert
        assertTrue(stack.isEmpty());
    }
}
