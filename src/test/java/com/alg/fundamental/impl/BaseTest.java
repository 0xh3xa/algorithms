package com.alg.fundamental.impl;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

public abstract class BaseTest {

    protected static final int ONE_INT = 1;
    protected static final int TWO_INT = 2;
    protected static final int THREE_INT = 3;
    protected static final int FOUR_INT = 4;
    protected static final int FIVE_INT = 5;
    protected static final double DOUBLE_ITEM_ONE = 5.5;
    protected static final double DOUBLE_ITEM_TWO = 4.5;
    protected static final String A_STRING = "a";
    protected static final String B_STRING = "b";
    protected static final String C_STRING = "c";
    protected static final String D_STRING = "d";
    protected static final String E_STRING = "e";
    protected static final String F_STRING = "f";
    protected static final String NOT_EQUAL_ASSERTION = "Not Equal Assertion!";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

}
