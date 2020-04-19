package com.alg.fundamentals.impl.queue;

import static org.hamcrest.CoreMatchers.*;

import com.alg.BaseTest;
import com.alg.fundamentals.base.Queue;

import org.junit.Before;
import org.junit.Test;

public class QueueLinkedListTest extends BaseTest {

    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new QueueLinkedList<>();
    }

    @Test
    public void shouldEnqueueAndDequeue() {
        // Arrange
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Act & Assert
        collector.checkThat(queue.size(), equalTo(5));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.dequeue(), equalTo(1));
        collector.checkThat(queue.size(), equalTo(4));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.dequeue(), equalTo(2));
        collector.checkThat(queue.dequeue(), equalTo(3));
        collector.checkThat(queue.dequeue(), equalTo(4));
        collector.checkThat(queue.dequeue(), equalTo(5));
        collector.checkThat(queue.size(), equalTo(0));
        collector.checkThat(queue.isEmpty(), equalTo(true));
    }

    @Test
    public void shouldThrowException() {
        // Assert
        expected.expect(IndexOutOfBoundsException.class);

        // Act
        queue.dequeue();
    }
}
