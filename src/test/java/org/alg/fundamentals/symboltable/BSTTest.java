package org.alg.fundamentals.symboltable;

import static org.hamcrest.CoreMatchers.equalTo;

import org.alg.BaseTest;
import org.alg.fundamentals.impl.symboltable.BST;
import org.junit.Before;
import org.junit.Test;

public class BSTTest extends BaseTest {

    private BST<String, Integer> bst;

    @Before
    public void setUp() {
        bst = new BST<>();
    }

    @Test
    public void shouldPutStringAndGetInteger() {
        // Arrange
        bst.put(ONE_STRING, ONE_INT);
        bst.put(TWO_STRING, TWO_INT);
        bst.put(THREE_STRING, THREE_INT);
        bst.put(FOUR_STRING, FOUR_INT);
        bst.put(FIVE_STRING, FIVE_INT);

        // Act & Assert
        collector.checkThat(bst.get(ONE_STRING), equalTo(ONE_INT));
        collector.checkThat(bst.size(), equalTo(5));
        collector.checkThat(bst.isEmpty(), equalTo(false));
        collector.checkThat(bst.get(TWO_STRING), equalTo(TWO_INT));
        collector.checkThat(bst.get(THREE_STRING), equalTo(THREE_INT));
        collector.checkThat(bst.get(FOUR_STRING), equalTo(FOUR_INT));
        collector.checkThat(bst.get(FIVE_STRING), equalTo(FIVE_INT));
        bst.delete(FIVE_STRING);
        collector.checkThat(bst.size(), equalTo(4));
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        // Assert
        expected.expect(IllegalArgumentException.class);

        // Arrange
        bst.put(null, ONE_INT);
    }
}