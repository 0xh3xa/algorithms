package com.alg.fundamental.excersises;

import static org.hamcrest.core.IsEqual.equalTo;

import com.alg.fundamental.impl.BaseTest;
import com.alg.fundamental.impl.StackArray;
import org.junit.Test;

public class StackArrayCopyStringTest extends BaseTest {

    @Test
    public void givenStackWhenCopyThenReturnNewStack() {
        // Arrange
        StackArray<String> orgStack = fillAndGetStack();

        // Act
        StackArray<String> actual = StackArrayCopyString.copy(orgStack);

        // Assert
        collector.checkThat(orgStack.size(), equalTo(5));
        collector.checkThat(actual.size(), equalTo(5));
        while (!orgStack.isEmpty()) {
            collector.checkThat(orgStack.pop(), equalTo(actual.pop()));
        }
    }

    private StackArray<String> fillAndGetStack() {
        StackArray<String> stack = new StackArray<>();
        stack.push(A_STRING);
        stack.push(B_STRING);
        stack.push(C_STRING);
        stack.push(D_STRING);
        stack.push(E_STRING);
        return stack;
    }
}
