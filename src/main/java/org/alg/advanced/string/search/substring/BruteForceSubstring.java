package org.alg.advanced.string.search.substring;

/**
 * Brute-force substring search for operation Index of Which return the first
 * occupance of substring in text
 */
public final class BruteForceSubstring {

    private BruteForceSubstring() throws IllegalAccessException {
        throw new IllegalAccessException("can not create an object from the class");
    }

    /**
     * Brute-force for indexOf
     * 
     * @param text String
     * @param sub  String
     * @return int
     */
    public final static int indexOf(String text, String sub) {
        int N = text.length();
        int M = sub.length();

        for (int i = 0; i <= N - M; i++) {
            for (int j = 0; j < M; j++) {
                if (sub.charAt(i + j) != text.charAt(j))
                    break;
                if (j == M)
                    return i; // index in text where patterns starts
            }
        }
        return -1; // not found
    }

    /**
     * Alternative impl brute-force with explicit backup
     * 
     * @param text String
     * @param sub  String
     * @return int
     */
    public final static int indexOfEnhanced(String text, String sub) {
        int i, N = text.length();
        int j, M = sub.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == sub.charAt(j))
                j++;
            else { // backup
                i -= j;
                j = 0;
            }
        }
        if (j == M)
            return i - M;
        else
            return -1;
    }
}
