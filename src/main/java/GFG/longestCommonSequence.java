package GFG;

import java.util.Arrays;

public class longestCommonSequence {
    private static int[][] dp = null;

    public static int lcsByMemo(String X, String Y, int m, int n) {
        if (dp[m][n] != -1)
            return dp[m][n];

        // Break Case
        if (m == 0 || n == 0) {
            dp[m][n] = 0;
        } else if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            dp[m][n] = 1 + lcsByMemo(X, Y, m - 1, n - 1);
        } else {
            dp[m][n] = Math.max(lcsByMemo(X, Y, m, n - 1), lcsByMemo(X, Y, m - 1, n));
        }

        return dp[m][n];
    }

    public static int lcsByTable(String X, String Y, int m, int n) {
        // Base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i][j - 1],
                            dp[i-1][j]
                    );
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = new String("AXYZ");
        String str2 = new String("AXZE");

        int m = str1.length();
        int n = str2.length();

        dp = new int[m + 1][n + 1];

        int[] initialArray = new int[n + 1];
        Arrays.fill(initialArray, -1);
        Arrays.fill(dp, initialArray);

        int resultByMemo = lcsByMemo(str1, str2, m, n);
        int resultByTable = lcsByTable(str1, str2, m, n);
        System.out.println("Result by Memo is " + resultByMemo);
        System.out.println("Result by Table is " + resultByTable);
    }
}
