package org.alg.fundamentals.sort;

import org.alg.BaseTest;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;

public class QuickSort3WayTest extends BaseTest {

    @Test
    public void shouldSortIntegerArray() {
        // Arrange
        Integer[] arr = {1, 8, -1, 83, -10, 7, 1, 10, 1, 62, 1, 1, 1};
        Integer[] sorted = {1, 8, -1, 83, -10, 7, 1, 10, 1, 62, 1, 1, 1};
        Arrays.sort(sorted);
        // Act
        QuickSort3Way.sort(arr);

        // Assert
        collector.checkThat(Arrays.equals(arr, sorted), equalTo(true));
    }

    @Test
    public void shouldSortCharacterArray() {
        // Arrange
        Character[] arr = {'a', 'z', 't', 'i', 'w', 'h', 't', 'n', 't', 't'};
        Character[] sorted = {'a', 'z', 't', 'i', 'w', 'h', 't', 'n', 't', 't'};
        Arrays.sort(sorted);

        // Act
        QuickSort3Way.sort(arr);

        // Assert
        collector.checkThat(Arrays.equals(arr, sorted), equalTo(true));
    }

    @Test
    public void shouldSortStringArray() {
        // Arrange
        String[] arr = {"hhh", "aaa", "ddd", "bbb", "ccc"};

        // Act
        QuickSort3Way.sort(arr);

        // Assert
        collector.checkThat(arr[0], equalTo("aaa"));
        collector.checkThat(arr[1], equalTo("bbb"));
        collector.checkThat(arr[2], equalTo("ccc"));
        collector.checkThat(arr[3], equalTo("ddd"));
        collector.checkThat(arr[4], equalTo("hhh"));
    }
}
