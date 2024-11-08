package GFG.DP.Neetcode;

import java.util.Arrays;

public class ErrorGeneratedAmazon {

    private static final int MOD = 1000000007;

    public static int getMinErrorSolved(String errorString, int x, int y) {
        int length = errorString.length();
        if (length == 0) {
            return 0;
        }

        // Use two 1-dimensional arrays instead of a 2D array to save memory
        int[] prev = new int[length + 1];
        int[] curr = new int[length + 1];

        // Initialize prev array with max values
        for (int j = 0; j <= length; j++) {
            prev[j] = Integer.MAX_VALUE;
        }
        prev[0] = 0;

        for (int i = 1; i <= length; i++) {
            // Initialize current row with max values
            for (int j = 0; j <= length; j++) {
                curr[j] = Integer.MAX_VALUE;
            }

            if (errorString.charAt(i - 1) == '0' || errorString.charAt(i - 1) == '!') {
                for (int j = 0; j <= i; j++) {
                    if (prev[j] < Integer.MAX_VALUE) {
                        // Update curr[j] instead of dp[i][j]
                        curr[j] = (int) Math.min(curr[j], (prev[j] + (long) j * y) % MOD);
                    }
                }
            }

            if (errorString.charAt(i - 1) == '1' || errorString.charAt(i - 1) == '!') {
                for (int j = 1; j <= i; j++) {
                    if (prev[j - 1] < Integer.MAX_VALUE) {
                        // Update curr[j] instead of dp[i][j]
                        curr[j] = (int) Math.min(curr[j], (prev[j - 1] + (long) x * (i - j)) % MOD);
                    }
                }
            }

            // Swap prev and curr arrays for the next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= length; i++) {
            min = Math.min(min, prev[i]); // Use prev as it holds the final row
        }

        return min % MOD;
    }

    public static int getMinError(String errorString, int x, int y) {
        int minZeroOneError = Math.min(
                helper(errorString.replace('!', '0'), '0', '1'),
                helper(errorString.replace('!', '1'), '0', '1')
        );
        int minOneZeroError = Math.min(
                helper(errorString.replace('!', '0'), '1', '0'),
                helper(errorString.replace('!', '1'), '1', '0')
        );

        return (minZeroOneError * x) + (minOneZeroError * y);
    }

    public static int helper(String errorString, char start, char end) {
        int n = errorString.length();

        int[] countToRight = new int[n];

        countToRight[n - 1] = (errorString.charAt(n - 1) == end) || (errorString.charAt(n - 1) == '!') ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            countToRight[i] = countToRight[i + 1] + (errorString.charAt(i) == end || (errorString.charAt(i) == '!') ? 1 : 0);
        }

        Arrays.toString(countToRight);

        int patternCount = 0;

        for (int i = 0; i < n - 1; i++) {
            if (errorString.charAt(i) == start) {
                patternCount += countToRight[i + 1];
            }
        }

        return patternCount;
    }

    public static void main(String[] args) {
        System.out.println(helper("10101", '0', '1'));
        System.out.println("Result for 101!1: " + getMinError("101!1", 2, 3));
        System.out.println("Result for !!111: " + getMinError("!!111", 3, 4));
        System.out.println("Result for 0!!1!1 " + getMinError("0!!1!1", 2, 3));

        System.out.println("Result for 101!1: " + getMinErrorSolved("101!1", 2, 3));
        System.out.println("Result for !!111 " + getMinErrorSolved("!!111", 3, 4));
        System.out.println("Result for 0!!1!1 " + getMinErrorSolved("0!!1!1", 2, 3));
    }
}