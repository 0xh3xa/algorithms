package com.alg.fundamental.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BagLinkedListTest extends BaseTest {

    @Test
    public void givenNumbersWhenAddThenIterate() {
        // Arrange
        BagLinkedList<Integer> bag = new BagLinkedList<>();
        int[] expected = {5, 4, 3, 2, 1};

        // Act
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);

        // Assert
        int pos = 0;
        for (Integer num : bag) {
            if (expected[pos++] != num) {
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
}
