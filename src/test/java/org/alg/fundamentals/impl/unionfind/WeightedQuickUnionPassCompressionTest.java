package org.alg.fundamentals.impl.unionfind;

import static org.hamcrest.CoreMatchers.*;

import org.alg.BaseTest;

import org.junit.Before;
import org.junit.Test;

public class WeightedQuickUnionPassCompressionTest extends BaseTest {

    private WeightedQuickUnionPassCompression quickUnion;
    private int size = 10;

    @Before
    public void setUp() {
        quickUnion = new WeightedQuickUnionPassCompression(size);
    }

    @Test
    public void shouldUnionAndFind() {
        // Act
        quickUnion.union(1, 9);
        quickUnion.union(2, 5);
        quickUnion.union(3, 5);
        quickUnion.union(3, 9);

        // Assert
        collector.checkThat(quickUnion.isConnected(1, 3), equalTo(true));
        collector.checkThat(quickUnion.isConnected(2, 5), equalTo(true));
        collector.checkThat(quickUnion.isConnected(3, 9), equalTo(true));
        collector.checkThat(quickUnion.isConnected(2, 9), equalTo(true));
        collector.checkThat(quickUnion.isConnected(1, 6), equalTo(false));
    }
}
