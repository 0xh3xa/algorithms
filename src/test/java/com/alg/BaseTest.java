package com.alg;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;

public abstract class BaseTest {

    public ErrorCollector collector = new ErrorCollector();
    public ExpectedException expected = ExpectedException.none();

    @Rule
    public RuleChain rule = RuleChain.outerRule(collector).around(expected);
}