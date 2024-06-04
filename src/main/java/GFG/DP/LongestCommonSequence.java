package GFG.DP;

import java.util.Arrays;

public class LongestCommonSequence {
    public static int LCS(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + LCS(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(LCS(s1, s2, n - 1, m), LCS(s1, s2, n, m - 1));
        }
    }

    public static int LCSMemo(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != Integer.MIN_VALUE) {
            return dp[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + LCSMemo(s1, s2, n - 1, m - 1, dp);
        } else {
            return Math.max(LCSMemo(s1, s2, n - 1, m, dp), LCSMemo(s1, s2, n, m - 1, dp));
        }
    }

    public static int LCSMemoization(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return LCSMemo(s1, s2, n, m, dp);
    }

    public static int LCSTabulation(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.max(Math.max(dp[i][j], dp[i - 1][j]), dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i][j], dp[i - 1][j]), dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String X = "ABCDGH"; // ADH
        String Y = "AEDFHR"; // ADH
//
//        String X = "ABCDEFGH"; // ADH
//        String Y = "AXBYCZE"; // ADH
        System.out.println(LCS(X, Y, X.length(), Y.length()));
        System.out.println(LCSTabulation(X, Y, X.length(), Y.length()));
        System.out.println(LCSMemoization(X, Y, X.length(), Y.length()));
    }
}
