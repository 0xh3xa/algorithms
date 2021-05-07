package org.alg.fundamentals.symboltable;

import org.alg.BaseTest;
import org.alg.fundamentals.impl.symboltable.LinearProbingHashST;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class LinearProbingHashSTTest extends BaseTest {

    private LinearProbingHashST<String, Integer> linearProbingHashST;

    @Before
    public void setUp() {
        linearProbingHashST = new LinearProbingHashST<>();
    }

    @Test
    public void shouldPutStringAndGetInteger() {
        // Arrange
        linearProbingHashST.put(ONE_STRING, ONE_INT);
        linearProbingHashST.put(TWO_STRING, TWO_INT);
        linearProbingHashST.put(THREE_STRING, THREE_INT);
        linearProbingHashST.put(FOUR_STRING, FOUR_INT);
        linearProbingHashST.put(FIVE_STRING, FIVE_INT);

        // Act & Assert
        collector.checkThat(linearProbingHashST.get(ONE_STRING), equalTo(ONE_INT));
        collector.checkThat(linearProbingHashST.size(), equalTo(5));
        collector.checkThat(linearProbingHashST.isEmpty(), equalTo(false));
        collector.checkThat(linearProbingHashST.get(TWO_STRING), equalTo(TWO_INT));
        collector.checkThat(linearProbingHashST.get(THREE_STRING), equalTo(THREE_INT));
        collector.checkThat(linearProbingHashST.get(FOUR_STRING), equalTo(FOUR_INT));
        collector.checkThat(linearProbingHashST.get(FIVE_STRING), equalTo(FIVE_INT));
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        // Assert
        expected.expect(IllegalArgumentException.class);

        // Arrange
        linearProbingHashST.put(null, ONE_INT);
    }
}