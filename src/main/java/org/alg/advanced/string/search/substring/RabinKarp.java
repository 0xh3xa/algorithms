package org.alg.advanced.string.search.substring;

import java.math.BigInteger;
import java.util.Random;

/**
 * Rabin-Karp substring search for operation Index of Which return the first
 * occupance of substring in text
 */
public class RabinKarp {

    private static final int R = 256;

    private final String pattern;
    private final long patternHash;
    private final int M; // pattern length
    private final long Q; // modulus
    private long RM; // R^(M-1) % Q

    public RabinKarp(String pattern) {
        this.pattern = pattern;
        M = pattern.length();
        Q = longRandomPrime();

        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patternHash = hash(pattern, M);
    }

    // a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    public int search(String text) {
        int N = text.length();
        if (N < M)
            return -1;

        // hash of first M characters in text
        long textHash = hash(text, M);

        if ((patternHash == textHash) && check(text, 0))
            return 0;

        // check for hash match; if hash match, check for exact match
        for (int i = M; i < N; i++) {
            // Remove leading digit
            textHash = (textHash + Q - RM * text.charAt(i - M) % Q) % Q;

            // Add trailing digit
            textHash = (textHash * R + text.charAt(i)) % Q;

            // Check match
            int offset = i - M + 1;
            if ((patternHash == textHash) && check(text, offset))
                return offset;
        }
        return -1;
    }

    // Las Vegas version: does pattern[] match text[i..i-m+1] ?
    private boolean check(String text, int i) {
        for (int j = 0; j < M; j++) {
            if (pattern.charAt(j) != text.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    // Monte Carlo version: always return true
    // private boolean check(String text, int i) {
    // return true;
    // }
}
