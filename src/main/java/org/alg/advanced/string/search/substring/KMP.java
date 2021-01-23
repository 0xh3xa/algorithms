package org.alg.advanced.string.search.substring;

public class KMP {

    private static final int R = 256;

    private int M;
    private int[][] dfa;

    public KMP(String pattern) {
        M = pattern.length();
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;
        for (int i = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][i]; // copy mis-match cases
            }
            dfa[pattern.charAt(j)][j] = j + 1; // set match case
            i = dfa[pattern.charAt(j)][i]; // update restart state
        }
    }

    public int search(String text) {
        int i, j, N = text.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j]; // no backup
        }
        if (j == M)
            return i - M;
        else
            return N;
    }
}