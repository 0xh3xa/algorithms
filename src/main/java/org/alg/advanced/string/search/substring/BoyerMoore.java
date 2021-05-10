package org.alg.advanced.string.search.substring;

/**
 * Boyer-Moore substring search for operation Index of Which return the first
 * occupance of substring in text
 */
public class BoyerMoore {

    private static final int R = 256;
    private int[] right;
    private String pattern;

    public BoyerMoore(String pattern) {
        this.pattern = pattern;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pattern.length(); j++)
            right[pattern.charAt(j)] = j;
    }

    public int indexOf(String text) {
        int N = text.length();
        int M = pattern.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }

            if (skip == 0)
                return i;
        }
        return -1; // not found
    }
}
