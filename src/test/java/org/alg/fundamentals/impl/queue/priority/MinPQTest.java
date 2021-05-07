package org.alg.fundamentals.impl.queue.priority;

import org.alg.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class MinPQTest extends BaseTest {

    private MinPQ<Integer> minPQ;

    @Before
    public void setUp() {
        minPQ = new MinPQ<>(10);
    }

    @Test
    public void shouldInsertAndDelMin() {
        // Arrange
        minPQ.insert(1);
        minPQ.insert(2);
        minPQ.insert(3);
        minPQ.insert(4);
        minPQ.insert(5);
        minPQ.insert(6);
        minPQ.insert(7);
        minPQ.insert(8);
        minPQ.insert(9);
        minPQ.insert(11);

        // Act & Assert
        collector.checkThat(minPQ.size(), equalTo(10));
        collector.checkThat(minPQ.isEmpty(), equalTo(false));
        collector.checkThat(minPQ.delMin(), equalTo(1));
        collector.checkThat(minPQ.size(), equalTo(9));
        collector.checkThat(minPQ.isEmpty(), equalTo(false));
        collector.checkThat(minPQ.delMin(), equalTo(2));
        collector.checkThat(minPQ.delMin(), equalTo(3));
        collector.checkThat(minPQ.delMin(), equalTo(4));
        collector.checkThat(minPQ.delMin(), equalTo(5));
        collector.checkThat(minPQ.size(), equalTo(5));
        collector.checkThat(minPQ.isEmpty(), equalTo(false));
        collector.checkThat(minPQ.delMin(), equalTo(6));
        collector.checkThat(minPQ.delMin(), equalTo(7));
        collector.checkThat(minPQ.delMin(), equalTo(8));
        collector.checkThat(minPQ.delMin(), equalTo(9));
        collector.checkThat(minPQ.size(), equalTo(1));
        collector.checkThat(minPQ.isEmpty(), equalTo(false));
    }

    @Test
    public void shouldThrowException() {
        // Assert
        expected.expect(IndexOutOfBoundsException.class);

        // Act
        minPQ.delMin();
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsException() {
        // Assert
        expected.expect(ArrayIndexOutOfBoundsException.class);

        // Arrange
        minPQ.insert(1);
        minPQ.insert(2);
        minPQ.insert(3);
        minPQ.insert(4);
        minPQ.insert(5);
        minPQ.insert(6);
        minPQ.insert(7);
        minPQ.insert(8);
        minPQ.insert(9);
        minPQ.insert(11);
        minPQ.insert(14);
    }
}
