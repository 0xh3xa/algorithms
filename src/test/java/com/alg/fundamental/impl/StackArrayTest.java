package com.alg.fundamental.impl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackArrayTest extends BaseTest {

    @Test
    public void givenDoubleValuesWhenPushThenPop() {
        // Arrange
        StackArray<Double> stack = new StackArray<>();

        // Act
        stack.push(DOUBLE_ITEM_ONE);
        stack.push(DOUBLE_ITEM_TWO);

        // Assert
        collector.checkThat(stack.pop(), equalTo(DOUBLE_ITEM_TWO));
        collector.checkThat(stack.pop(), equalTo(DOUBLE_ITEM_ONE));
        collector.checkThat(stack.isEmpty(), equalTo(true));
    }

    @Test
    public void givenEmptyValuesWhenIsEmptyThenReturnTrue() {
        // Arrange
        StackArray<String> stack = new StackArray<>();

        // Act & Assert
        assertTrue(stack.isEmpty());
    }
}
