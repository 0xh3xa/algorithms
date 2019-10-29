package com.alg.fundamental.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExpressionEvaluateTest {

    @Test
    public void givenExpressionOneWhenEvaluateThenReturnValue() {
        // Arrange
        ExpressionEvaluate evaluate = new ExpressionEvaluate();

        // Act
        Double actual = evaluate.eval("(1+((2+3)*(4*5)))");

        // Assert
        assertEquals(actual, 101.0, 0);
    }

    @Test
    public void givenSqrtExpressionWhenEvaluateThenReturnValue() {
        // Arrange
        ExpressionEvaluate evaluate = new ExpressionEvaluate();

        // Act
        Double actual = evaluate.eval("(2+sqrt(49))");

        // Assert
        assertEquals(actual, 9.0, 0);
    }
}
