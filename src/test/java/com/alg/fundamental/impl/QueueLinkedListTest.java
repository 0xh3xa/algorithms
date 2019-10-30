package com.alg.fundamental.impl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueLinkedListTest extends BaseTest {

    @Test
    public void givenDoubleValuesWhenPushThenDequeue() {
        // Arrange
        QueueLinkedList<Double> queue = new QueueLinkedList<>();

        // Act
        queue.enqueue(DOUBLE_ITEM_ONE);
        queue.enqueue(DOUBLE_ITEM_TWO);

        // Assert
        collector.checkThat(queue.dequeue(), equalTo(DOUBLE_ITEM_ONE));
        collector.checkThat(queue.dequeue(), equalTo(DOUBLE_ITEM_TWO));
        collector.checkThat(queue.isEmpty(), equalTo(true));
    }

    @Test
    public void givenEmptyValuesWhenIsEmptyThenReturnTrue() {
        // Arrange
        QueueLinkedList<String> stack = new QueueLinkedList<>();

        // Act & Assert
        assertTrue(stack.isEmpty());
    }
}
