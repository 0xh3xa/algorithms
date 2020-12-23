package org.alg.fundamentals.sort;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

import org.alg.BaseTest;

import org.junit.Test;

public class KnuthShuffleSortTest extends BaseTest {

    @Test
    public void shouldShuffleSortedArray() {
        // Arrange
        Integer[] arr = new Integer[50];
        for (int i = 0; i < 50; i++) {
            arr[i] = i + 1;
        }

        // Act
        ShellSort.sort(arr);

        // Assert
        for (int i = 0; i < 50; i++) {
            collector.checkThat(arr[i], not(equalTo(i)));
        }
    }
}
