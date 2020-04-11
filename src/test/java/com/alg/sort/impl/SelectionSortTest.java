package com.alg.sort.impl;

import static org.hamcrest.CoreMatchers.equalTo;

import com.alg.BaseTest;

import org.junit.Test;

public class SelectionSortTest extends BaseTest {

    @Test
    public void shouldSortIntegerArray() {
        // Arrange
        Integer[] arr = { 1, 8, -1, 83, -10, 7 };

        // Act
        SelectionSort.sort(arr);

        // Assert
        collector.checkThat(arr[0], equalTo(-10));
        collector.checkThat(arr[1], equalTo(-1));
        collector.checkThat(arr[2], equalTo(1));
        collector.checkThat(arr[3], equalTo(7));
        collector.checkThat(arr[4], equalTo(8));
        collector.checkThat(arr[5], equalTo(83));
    }

    @Test
    public void shouldSortCharacterArray() {
        // Arrange
        Character[] arr = { 'a', 'z', 't', 'i', 'w', 'h' };

        // Act
        SelectionSort.sort(arr);

        // Assert
        collector.checkThat(arr[0], equalTo('a'));
        collector.checkThat(arr[1], equalTo('h'));
        collector.checkThat(arr[2], equalTo('i'));
        collector.checkThat(arr[3], equalTo('t'));
        collector.checkThat(arr[4], equalTo('w'));
        collector.checkThat(arr[5], equalTo('z'));
    }
}