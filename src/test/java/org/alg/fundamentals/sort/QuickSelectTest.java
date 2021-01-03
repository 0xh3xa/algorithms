package org.alg.fundamentals.sort;

import static org.hamcrest.CoreMatchers.equalTo;

import org.alg.BaseTest;

import org.junit.Test;

public class QuickSelectTest extends BaseTest {

    @Test
    public void shouldFindKthNumber() {
        // Arrange
        Integer[] arr = { 1, 8, -1, 83, -10, 7 };

        // Act
        Integer actual = (Integer) QuickSelect.select(arr, 2);

        // Assert
        collector.checkThat(actual, equalTo(1));
    }

    @Test
    public void shouldFindKthNumber2() {
        // Arrange
        Integer[] arr = { 1, 8, -1, 83, -10, 7 };

        // Act
        Integer actual = (Integer) QuickSelect.select(arr, 3);

        // Assert
        collector.checkThat(actual, equalTo(7));
    }

    @Test
    public void shouldFindKthNumber3() {
        // Arrange
        Integer[] arr = { 1, 8, -1, 83, -10, 7 };

        // Act
        Integer actual = (Integer) QuickSelect.select(arr, 0);

        // Assert
        collector.checkThat(actual, equalTo(-10));
    }
}
