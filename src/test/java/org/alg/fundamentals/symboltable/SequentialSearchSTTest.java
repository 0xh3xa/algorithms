package org.alg.fundamentals.symboltable;

import static org.hamcrest.CoreMatchers.equalTo;

import org.alg.BaseTest;
import org.alg.fundamentals.impl.symboltable.SequentialSearchST;
import org.junit.Before;
import org.junit.Test;

public class SequentialSearchSTTest extends BaseTest {

    private SequentialSearchST<String, Integer> sequentialSearchST;

    @Before
    public void setUp() {
        sequentialSearchST = new SequentialSearchST<>();
    }

    @Test
    public void shouldPutStringAndGetInteger() {
        // Arrange
        sequentialSearchST.put(ONE_STRING, ONE_INT);
        sequentialSearchST.put(TWO_STRING, TWO_INT);
        sequentialSearchST.put(THREE_STRING, THREE_INT);
        sequentialSearchST.put(FOUR_STRING, FOUR_INT);
        sequentialSearchST.put(FIVE_STRING, FIVE_INT);

        // Act & Assert
        collector.checkThat(sequentialSearchST.get(ONE_STRING), equalTo(ONE_INT));
        collector.checkThat(sequentialSearchST.size(), equalTo(5));
        collector.checkThat(sequentialSearchST.isEmpty(), equalTo(false));
        collector.checkThat(sequentialSearchST.get(TWO_STRING), equalTo(TWO_INT));
        collector.checkThat(sequentialSearchST.get(THREE_STRING), equalTo(THREE_INT));
        collector.checkThat(sequentialSearchST.get(FOUR_STRING), equalTo(FOUR_INT));
        collector.checkThat(sequentialSearchST.get(FIVE_STRING), equalTo(FIVE_INT));
        sequentialSearchST.delete(FIVE_STRING);
        collector.checkThat(sequentialSearchST.size(), equalTo(4));
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        // Assert
        expected.expect(IllegalArgumentException.class);

        // Arrange
        sequentialSearchST.put(null, ONE_INT);
    }
}