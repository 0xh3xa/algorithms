package com.alg.fundamentals;

import static org.hamcrest.CoreMatchers.*;

import java.util.Iterator;

import com.alg.BaseTest;
import com.alg.fundamentals.impl.Bag;

import org.junit.Before;
import org.junit.Test;

public class BagTest extends BaseTest {

    @Test
    public void shouldAdd() {
        // Arrange
        Bag<Integer> bag = new Bag<>();

        // Act
        bag.add(Integer.valueOf(ONE_INT));
        bag.add(Integer.valueOf(TWO_INT));
        bag.add(Integer.valueOf(THREE_INT));
        bag.add(Integer.valueOf(FOUR_INT));
        bag.add(Integer.valueOf(FIVE_INT));

        // Assert
        collector.checkThat(bag.size(), equalTo(5));
        collector.checkThat(bag.isEmpty(), equalTo(false));
        Iterator<Integer> iterator = bag.iterator();
        int verify = 5;
        while (iterator.hasNext()) {
            collector.checkThat(iterator.next(), equalTo(Integer.valueOf(verify--)));
        }
    }
}