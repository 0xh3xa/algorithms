package org.alg.fundamentals.impl.queue.priority;

import static org.hamcrest.CoreMatchers.equalTo;

import org.alg.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class MaxPQTest extends BaseTest {

    private MaxPQ<Integer> maxPQ;

    @Before
    public void setUp() {
        maxPQ = new MaxPQ<>(10);
    }

    @Test
    public void shouldInsertAndDelMax() {
        // Arrange
        maxPQ.insert(1);
        maxPQ.insert(2);
        maxPQ.insert(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.insert(6);
        maxPQ.insert(7);
        maxPQ.insert(8);
        maxPQ.insert(9);
        maxPQ.insert(11);

        // Act & Assert
        collector.checkThat(maxPQ.size(), equalTo(10));
        collector.checkThat(maxPQ.isEmpty(), equalTo(false));
        collector.checkThat(maxPQ.delMax(), equalTo(11));
        collector.checkThat(maxPQ.size(), equalTo(9));
        collector.checkThat(maxPQ.isEmpty(), equalTo(false));
        collector.checkThat(maxPQ.delMax(), equalTo(9));
        collector.checkThat(maxPQ.delMax(), equalTo(8));
        collector.checkThat(maxPQ.delMax(), equalTo(7));
        collector.checkThat(maxPQ.delMax(), equalTo(6));
        collector.checkThat(maxPQ.size(), equalTo(5));
        collector.checkThat(maxPQ.isEmpty(), equalTo(false));
        collector.checkThat(maxPQ.delMax(), equalTo(5));
        collector.checkThat(maxPQ.delMax(), equalTo(4));
        collector.checkThat(maxPQ.delMax(), equalTo(3));
        collector.checkThat(maxPQ.delMax(), equalTo(2));
        collector.checkThat(maxPQ.size(), equalTo(1));
        collector.checkThat(maxPQ.isEmpty(), equalTo(false));
    }

    @Test
    public void shouldThrowException() {
        // Assert
        expected.expect(IndexOutOfBoundsException.class);

        // Act
        maxPQ.delMax();
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsException() {
        // Assert
        expected.expect(ArrayIndexOutOfBoundsException.class);

        // Arrange
        maxPQ.insert(1);
        maxPQ.insert(2);
        maxPQ.insert(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.insert(6);
        maxPQ.insert(7);
        maxPQ.insert(8);
        maxPQ.insert(9);
        maxPQ.insert(11);
        maxPQ.insert(14);
    }
}