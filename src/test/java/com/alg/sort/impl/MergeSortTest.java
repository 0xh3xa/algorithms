package com.alg.sort.impl;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Comparator;

import com.alg.BaseTest;

import org.junit.Test;

public class MergeSortTest extends BaseTest {

    @Test
    public void shouldSortBigIntegerArray() {
        // Arrange
        Integer[] arr = { 32 };
        int N = arr.length;
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = i;
        }

        // Act
        MergeSort.sort(arr, new Integer[N], 0, N - 1);

        // Assert
        for (int i = 0; i < N; i++) {
            collector.checkThat(arr[i], equalTo(i));
        }
    }

    @Test
    public void shouldSortIntegerArray() {
        // Arrange
        Integer[] arr = { 1, 8, -1, 83, -10, 7, 19, 768, 621, 6, -39, 1000, -50 };
        int N = arr.length;

        // Act
        MergeSort.sort(arr, new Integer[N], 0, N - 1);

        // Assert
        collector.checkThat(arr[0], equalTo(-50));
        collector.checkThat(arr[1], equalTo(-39));
        collector.checkThat(arr[2], equalTo(-10));
        collector.checkThat(arr[3], equalTo(-1));
        collector.checkThat(arr[4], equalTo(1));
        collector.checkThat(arr[5], equalTo(6));
        collector.checkThat(arr[6], equalTo(7));
        collector.checkThat(arr[7], equalTo(8));
        collector.checkThat(arr[8], equalTo(19));
        collector.checkThat(arr[9], equalTo(83));
        collector.checkThat(arr[10], equalTo(621));
        collector.checkThat(arr[11], equalTo(768));
        collector.checkThat(arr[12], equalTo(1000));
    }

    @Test
    public void shouldSortCharacterArray() {
        // Arrange
        Character[] arr = { 'a', 'z', 't', 'i', 'w', 'h' };
        int N = arr.length;

        // Act
        MergeSort.sort(arr, new Character[N], 0, N - 1);

        // Assert
        collector.checkThat(arr[0], equalTo('a'));
        collector.checkThat(arr[1], equalTo('h'));
        collector.checkThat(arr[2], equalTo('i'));
        collector.checkThat(arr[3], equalTo('t'));
        collector.checkThat(arr[4], equalTo('w'));
        collector.checkThat(arr[5], equalTo('z'));
    }

    @Test
    public void shouldSortComparatorAndCIntegerArray() {
        // Arrange
        Integer[] arr = { 1, 8, -1, 83, -10, 7 };

        // Act
        InsertionSort.sort(arr, Comparator.naturalOrder());

        // Assert
        collector.checkThat(arr[0], equalTo(-10));
        collector.checkThat(arr[1], equalTo(-1));
        collector.checkThat(arr[2], equalTo(1));
        collector.checkThat(arr[3], equalTo(7));
        collector.checkThat(arr[4], equalTo(8));
        collector.checkThat(arr[5], equalTo(83));
    }

    @Test
    public void shouldSortComparatorAndCharacterArray() {
        // Arrange
        Character[] arr = { 'a', 'z', 't', 'i', 'w', 'h' };

        // Act
        InsertionSort.sort(arr, Comparator.naturalOrder());

        // Assert
        collector.checkThat(arr[0], equalTo('a'));
        collector.checkThat(arr[1], equalTo('h'));
        collector.checkThat(arr[2], equalTo('i'));
        collector.checkThat(arr[3], equalTo('t'));
        collector.checkThat(arr[4], equalTo('w'));
        collector.checkThat(arr[5], equalTo('z'));
    }

    @Test
    public void shouldSortStringArray() {
        // Arrange
        String[] arr = { "hhh", "aaa", "ddd", "bbb", "ccc" };
        int N = arr.length;

        // Act
        MergeSort.sort(arr, new String[N], 0, N - 1);

        // Assert
        collector.checkThat(arr[0], equalTo("aaa"));
        collector.checkThat(arr[1], equalTo("bbb"));
        collector.checkThat(arr[2], equalTo("ccc"));
        collector.checkThat(arr[3], equalTo("ddd"));
        collector.checkThat(arr[4], equalTo("hhh"));
    }

    @Test
    public void shouldSortBottomUpIntegerArray() {
        // Arrange
        Integer[] arr = { 1, 8, -1, 83, -10, 7, 19, 768, 621, 6, -39, 1000, -50 };

        // Act
        MergeSort.sortBottomUp(arr);

        // Assert
        collector.checkThat(arr[0], equalTo(-50));
        collector.checkThat(arr[1], equalTo(-39));
        collector.checkThat(arr[2], equalTo(-10));
        collector.checkThat(arr[3], equalTo(-1));
        collector.checkThat(arr[4], equalTo(1));
        collector.checkThat(arr[5], equalTo(6));
        collector.checkThat(arr[6], equalTo(7));
        collector.checkThat(arr[7], equalTo(8));
        collector.checkThat(arr[8], equalTo(19));
        collector.checkThat(arr[9], equalTo(83));
        collector.checkThat(arr[10], equalTo(621));
        collector.checkThat(arr[11], equalTo(768));
        collector.checkThat(arr[12], equalTo(1000));
    }

    @Test
    public void shouldSortBottomUpCharacterArray() {
        // Arrange
        Character[] arr = { 'a', 'z', 't', 'i', 'w', 'h' };

        // Act
        MergeSort.sortBottomUp(arr);

        // Assert
        collector.checkThat(arr[0], equalTo('a'));
        collector.checkThat(arr[1], equalTo('h'));
        collector.checkThat(arr[2], equalTo('i'));
        collector.checkThat(arr[3], equalTo('t'));
        collector.checkThat(arr[4], equalTo('w'));
        collector.checkThat(arr[5], equalTo('z'));
    }

    @Test
    public void shouldSortBottomUpStringArray() {
        // Arrange
        String[] arr = { "hhh", "aaa", "ddd", "bbb", "ccc" };

        // Act
        MergeSort.sortBottomUp(arr);

        // Assert
        collector.checkThat(arr[0], equalTo("aaa"));
        collector.checkThat(arr[1], equalTo("bbb"));
        collector.checkThat(arr[2], equalTo("ccc"));
        collector.checkThat(arr[3], equalTo("ddd"));
        collector.checkThat(arr[4], equalTo("hhh"));
    }
}