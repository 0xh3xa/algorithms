package com.alg.fundamental.excersises;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryRepresentationTest {

    @Test
    public void givenNumberWhenGetBinaryThenReturnBinary() {
        // Arrange
        BinaryRepresentation binaryRepr = new BinaryRepresentation();

        // Act & Assert
        assertEquals("1 1 0 0 1 0", binaryRepr.getBinary(50));
    }
}
