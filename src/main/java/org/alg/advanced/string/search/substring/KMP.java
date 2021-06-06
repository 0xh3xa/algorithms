package org.alg.advanced.string.search.substring;

/**
 * class represents Knuth-Morris-Pratt substring implementation
 */
public class KMP {

    private final int R;
    private final int M;
    private int[][] dfa;

    /**
     * pattern used for search in a text
     * @param pattern String
     */
    public KMP(String pattern) {
        R = 256;
        M = pattern.length();

        // build the DFA
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

    public KMP(String pattern, int r) {
        R = r;
        M = pattern.length();

        // build the DFA
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

    /**
     * text string to apply pattern on
     * @param text String
     * @return int
     */
    public int search(String text) {
        int i, j, N = text.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j]; // no backup
        }
        if (j == M)
            return i - M;
        else
            return -1;
    }
}
