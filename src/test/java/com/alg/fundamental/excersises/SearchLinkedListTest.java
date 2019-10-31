package com.alg.fundamental.excersises;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.alg.fundamental.impl.BaseTest;
import com.alg.fundamental.impl.QueueLinkedList;
import org.junit.Test;

public class SearchLinkedListTest extends BaseTest {

    @Test
    public void givenKeyWhenFindThenReturnTrue() {
        // Arrange
        QueueLinkedList<String> queue = fillAndGetQueue();

        // Act
        assertTrue(SearchLinkedList.hasItem(A_STRING, queue));
    }

    @Test
    public void givenNotFoundKeyWhenFindThenReturnFalse() {
        // Arrange
        QueueLinkedList<String> queue = fillAndGetQueue();

        // Act
        assertFalse(SearchLinkedList.hasItem(F_STRING, queue));
    }

    private QueueLinkedList<String> fillAndGetQueue() {
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        queue.enqueue(A_STRING);
        queue.enqueue(B_STRING);
        queue.enqueue(C_STRING);
        queue.enqueue(D_STRING);
        queue.enqueue(E_STRING);
        return queue;
    }
}
