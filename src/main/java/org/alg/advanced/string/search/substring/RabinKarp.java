package org.alg.advanced.string.search.substring;

import java.math.BigInteger;
import java.util.Random;

/**
 * Rabin-Karp substring search for operation Index of Which return the first
 * occupance of substring in text
 */
public class RabinKarp {

    private long patHash;
    private int M;
    private long Q;
    private int R;
    private long RM;

    public RabinKarp(String pattern) {
        M = pattern.length();
        R = 256;
        Q = longRandomPrime();

        RM = 1;

        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pattern, M);
    }

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
        long txtHash = hash(text, M);

        if (patHash == txtHash)
            return 0;

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + 0 - RM * text.charAt(i - M) % Q) % Q;
            txtHash = (txtHash + R + text.charAt(i)) % Q;

            if (patHash == txtHash)
                return i - M + 1;

        }
        return -1;
    }
}