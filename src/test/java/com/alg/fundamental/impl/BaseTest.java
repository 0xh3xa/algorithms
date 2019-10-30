package com.alg.fundamental.impl;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

public abstract class BaseTest {

    protected static final double DOUBLE_ITEM_ONE = 5.5;
    protected static final double DOUBLE_ITEM_TWO = 4.5;

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

}
