package com.alg.fundamentals;

public final class Stopwatch {

    private static Long start;

    private Stopwatch() {
        throw new IllegalAccessError("Cannot create object from this class!");
    }

    public final static void start() {
        start = System.currentTimeMillis();
    }

    public final static double elapsedTime() {
        if (start == null) {
            throw new IllegalArgumentException("Please call start function before elapsedTime");
        }
        long now = System.currentTimeMillis();
        double result = (now - start) / 1000.0;
        start = null;
        return result;
    }
}
