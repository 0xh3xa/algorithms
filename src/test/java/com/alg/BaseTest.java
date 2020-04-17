package com.alg;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;

public abstract class BaseTest {

    protected static final String ONE_STRING = "one";
    protected static final String TWO_STRING = "two";
    protected static final String THREE_STRING = "three";
    protected static final String FOUR_STRING = "four";
    protected static final String FIVE_STRING = "five";
    protected static final int ONE_INT = 1;
    protected static final int TWO_INT = 2;
    protected static final int THREE_INT = 3;
    protected static final int FOUR_INT = 4;
    protected static final int FIVE_INT = 5;

    public ErrorCollector collector = new ErrorCollector();
    public ExpectedException expected = ExpectedException.none();

    @Rule
    public RuleChain rule = RuleChain.outerRule(collector).around(expected);
}