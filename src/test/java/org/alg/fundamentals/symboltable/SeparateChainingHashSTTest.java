package org.alg.fundamentals.symboltable;

import static org.hamcrest.CoreMatchers.equalTo;

import org.alg.BaseTest;
import org.alg.fundamentals.impl.symboltable.SeparateChainingHashST;
import org.junit.Before;
import org.junit.Test;

public class SeparateChainingHashSTTest extends BaseTest {

    private SeparateChainingHashST<String, Integer> separateChainingHashST;

    @Before
    public void setUp() {
        separateChainingHashST = new SeparateChainingHashST<>();
    }

    @Test
    public void shouldPutStringAndGetInteger() {
        // Arrange
        separateChainingHashST.put(ONE_STRING, ONE_INT);
        separateChainingHashST.put(TWO_STRING, TWO_INT);
        separateChainingHashST.put(THREE_STRING, THREE_INT);
        separateChainingHashST.put(FOUR_STRING, FOUR_INT);
        separateChainingHashST.put(FIVE_STRING, FIVE_INT);

        // Act & Assert
        collector.checkThat(separateChainingHashST.get(ONE_STRING), equalTo(ONE_INT));
        collector.checkThat(separateChainingHashST.size(), equalTo(5));
        collector.checkThat(separateChainingHashST.isEmpty(), equalTo(false));
        collector.checkThat(separateChainingHashST.get(TWO_STRING), equalTo(TWO_INT));
        collector.checkThat(separateChainingHashST.get(THREE_STRING), equalTo(THREE_INT));
        collector.checkThat(separateChainingHashST.get(FOUR_STRING), equalTo(FOUR_INT));
        collector.checkThat(separateChainingHashST.get(FIVE_STRING), equalTo(FIVE_INT));
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        // Assert
        expected.expect(IllegalArgumentException.class);

        // Arrange
        separateChainingHashST.put(null, ONE_INT);
    }
}