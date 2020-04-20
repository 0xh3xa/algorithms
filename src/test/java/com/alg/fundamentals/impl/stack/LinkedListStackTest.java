package com.alg.fundamentals.impl.stack;

import static org.hamcrest.CoreMatchers.*;

import com.alg.BaseTest;
import com.alg.fundamentals.base.Stack;

import org.junit.Before;
import org.junit.Test;

public class LinkedListStackTest extends BaseTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new LinkedListStack<>();
    }

    @Test
    public void shouldPushAndPop() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Act & Assert
        collector.checkThat(stack.size(), equalTo(5));
        collector.checkThat(stack.isEmpty(), equalTo(false));
        collector.checkThat(stack.pop(), equalTo(5));
        collector.checkThat(stack.size(), equalTo(4));
        collector.checkThat(stack.isEmpty(), equalTo(false));
        collector.checkThat(stack.pop(), equalTo(4));
        collector.checkThat(stack.pop(), equalTo(3));
        collector.checkThat(stack.pop(), equalTo(2));
        collector.checkThat(stack.pop(), equalTo(1));
        collector.checkThat(stack.size(), equalTo(0));
        collector.checkThat(stack.isEmpty(), equalTo(true));
    }

    @Test
    public void shouldThrowException() {
        // Assert
        expected.expect(IndexOutOfBoundsException.class);

        // Act
        stack.pop();
    }
}
