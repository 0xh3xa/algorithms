package com.alg.impl.queue;

import static org.hamcrest.CoreMatchers.*;

import com.alg.BaseTest;
import com.alg.base.Queue;

import org.junit.Before;
import org.junit.Test;

public class QueueArrayTest extends BaseTest {

    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new QueueArray<>();
    }

    @Test
    public void shouldEnqueueAndDequeue() {
        // Arrange
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(11);

        // Act & Assert
        collector.checkThat(queue.size(), equalTo(10));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.dequeue(), equalTo(1));
        collector.checkThat(queue.size(), equalTo(9));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.dequeue(), equalTo(2));
        collector.checkThat(queue.dequeue(), equalTo(3));
        collector.checkThat(queue.dequeue(), equalTo(4));
        collector.checkThat(queue.dequeue(), equalTo(5));
        collector.checkThat(queue.size(), equalTo(5));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.dequeue(), equalTo(6));
        collector.checkThat(queue.dequeue(), equalTo(7));
        collector.checkThat(queue.dequeue(), equalTo(8));
        collector.checkThat(queue.dequeue(), equalTo(9));
        collector.checkThat(queue.size(), equalTo(1));
        collector.checkThat(queue.isEmpty(), equalTo(false));
    }

    @Test
    public void shouldThrowException() {
        // Assert
        expected.expect(IndexOutOfBoundsException.class);

        // Act
        queue.dequeue();
    }
}
