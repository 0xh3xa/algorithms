package com.alg.impl;

import static org.hamcrest.CoreMatchers.*;

import com.alg.BaseTest;

import org.junit.Before;
import org.junit.Test;

public class QuickFindTest extends BaseTest{

    private QuickFind quickFind;
    private int N = 10;

    @Before
    public void setUp() {
        quickFind = new QuickFind(N);
    }

    @Test
    public void shouldUnionAndFind() {
        // Act
        quickFind.union(1, 9);
        quickFind.union(2, 5);
        quickFind.union(3, 5);
        quickFind.union(3, 9);

        // Assert
        collector.checkThat(quickFind.isConnected(1, 3), equalTo(true));
        collector.checkThat(quickFind.isConnected(2, 5), equalTo(true));
        collector.checkThat(quickFind.isConnected(3, 9), equalTo(true));
        collector.checkThat(quickFind.isConnected(2, 9), equalTo(true));
        collector.checkThat(quickFind.isConnected(1, 6), equalTo(false));
    }
}
