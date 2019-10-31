package com.alg.fundamental.impl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Comparator;
import org.junit.Test;

public class LinkedListImplTest extends BaseTest {

    @Test
    public void givenAddElementsWhenAddThenCheckSize() {
        // Arrange
        LinkedListImpl<String> linkedList = new LinkedListImpl<>();
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        queue.enqueue(A_STRING);
        queue.enqueue(B_STRING);
        queue.enqueue(C_STRING);
        queue.enqueue(D_STRING);
        queue.enqueue(E_STRING);

        // Act
        linkedList.add(A_STRING);
        linkedList.add(B_STRING);
        linkedList.add(C_STRING);
        linkedList.add(D_STRING);
        linkedList.add(E_STRING);

        // Assert
        collector.checkThat(linkedList.size(), equalTo(5));
        for (String string : linkedList) {
            if (!queue.dequeue().equalsIgnoreCase(string)) {
                fail(NOT_EQUAL_ASSERTION);
            }
        }
        collector.checkThat(true, equalTo(true));
    }

    @Test
    public void givenElementsWhenAddThenRemove() {
        // Arrange
        LinkedListImpl<String> linkedList = fillAndGetLinkedListImpl();

        // Act
        String actual = linkedList.remove(A_STRING);

        // Assert
        collector.checkThat(actual, equalTo(A_STRING));
        collector.checkThat(linkedList.size(), equalTo(4));
        checkIfContainsElement(A_STRING, linkedList);
    }

    @Test
    public void givenElementsWhenAddThenRemoveAll() {
        // Arrange
        LinkedListImpl<String> linkedList = fillAndGetLinkedListImpl();
        linkedList.add(B_STRING);
        linkedList.add(A_STRING);
        linkedList.add(F_STRING);

        // Act
        String actual = linkedList.removeAll(A_STRING);

        // Assert
        collector.checkThat(actual, equalTo(A_STRING));
        collector.checkThat(linkedList.size(), equalTo(6));
        checkIfContainsElement(A_STRING, linkedList);
    }

    @Test
    public void givenElementsWhenAddThenMax() {
        // Arrange
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(ONE_INT);
        linkedList.add(TWO_INT);
        linkedList.add(THREE_INT);
        linkedList.add(FOUR_INT);
        linkedList.add(FIVE_INT);

        // Act & Assert
        assertEquals(FIVE_INT, linkedList.max(Comparator.naturalOrder()).intValue());
    }

    @Test
    public void givenElementsWhenAddThenMaxRecursive() {
        // Arrange
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(ONE_INT);
        linkedList.add(TWO_INT);
        linkedList.add(THREE_INT);
        linkedList.add(FOUR_INT);
        linkedList.add(FIVE_INT);

        // Act & Assert
        assertEquals(FIVE_INT, linkedList.maxRecursive(Comparator.naturalOrder()).intValue());
    }

    @Test
    public void givenElementsWhenAddThenMin() {
        // Arrange
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(ONE_INT);
        linkedList.add(TWO_INT);
        linkedList.add(THREE_INT);
        linkedList.add(FOUR_INT);
        linkedList.add(FIVE_INT);

        // Act & Assert
        assertEquals(ONE_INT, linkedList.min(Comparator.naturalOrder()).intValue());
    }

    private LinkedListImpl<String> fillAndGetLinkedListImpl() {
        LinkedListImpl<String> linkedList = new LinkedListImpl<>();
        linkedList.add(A_STRING);
        linkedList.add(B_STRING);
        linkedList.add(C_STRING);
        linkedList.add(D_STRING);
        linkedList.add(E_STRING);
        return linkedList;
    }

    private void checkIfContainsElement(String element,
            LinkedListImpl<String> linkedList) {
        for (String string : linkedList) {
            if (element.equalsIgnoreCase(string)) {
                fail(NOT_EQUAL_ASSERTION);
            }
        }
    }
}
