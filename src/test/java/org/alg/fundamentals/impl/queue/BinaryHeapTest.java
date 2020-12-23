package org.alg.fundamentals.impl.queue;

import static org.hamcrest.CoreMatchers.equalTo;

import org.alg.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class BinaryHeapTest extends BaseTest {

    private BinaryHeap<Integer> queue;

    @Before
    public void setUp() {
        queue = new BinaryHeap<>(15);
    }

    @Test
    public void shouldInsertAndDequeue() {
        // Arrange
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        queue.insert(11);

        // Act & Assert
        collector.checkThat(queue.size(), equalTo(10));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.delMax(), equalTo(11));
        collector.checkThat(queue.size(), equalTo(9));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.delMax(), equalTo(9));
        collector.checkThat(queue.delMax(), equalTo(8));
        collector.checkThat(queue.delMax(), equalTo(7));
        collector.checkThat(queue.delMax(), equalTo(6));
        collector.checkThat(queue.size(), equalTo(5));
        collector.checkThat(queue.isEmpty(), equalTo(false));
        collector.checkThat(queue.delMax(), equalTo(5));
        collector.checkThat(queue.delMax(), equalTo(4));
        collector.checkThat(queue.delMax(), equalTo(3));
        collector.checkThat(queue.delMax(), equalTo(2));
        collector.checkThat(queue.size(), equalTo(1));
        collector.checkThat(queue.isEmpty(), equalTo(false));
    }

    @Test
    public void shouldThrowException() {
        // Assert
        expected.expect(IndexOutOfBoundsException.class);

        // Act
        queue.delMax();
    }
}
