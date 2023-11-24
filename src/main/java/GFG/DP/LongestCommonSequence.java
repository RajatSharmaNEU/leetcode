package GFG.DP;

public class LongestCommonSequence {
    private int LCSequenceMemoSolution(String X, String Y, int m, int n, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;

        // do not recalculate for same n and m
        // Cache
        if (dp[m][n] != -1)
            return dp[m][n];

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            dp[m][n] = 1 + LCSequenceMemoSolution(X, Y, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(LCSequenceMemoSolution(X, Y, m, n - 1, dp),
                    LCSequenceMemoSolution(X, Y, m - 1, n, dp));
        }
        return dp[m][n];
    }


    private int LCSequenceNaiveSolution(String s1, String s2, int l1, int l2) {
        if (l1 == 0 || l2 == 0) {
            return 0;
        }

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return 1 + LCSequenceNaiveSolution(s1, s2, l1 - 1, l2 - 1);
        } else {
            return Math.max(
                    LCSequenceNaiveSolution(s1, s2, l1, l2 - 1),
                    LCSequenceNaiveSolution(s1, s2, l1 - 1, l2)
            );
        }
    }

    public static void main(String[] args) {
        LongestCommonSequence longestCommonSequence = new LongestCommonSequence();
        String X = "ABCDGH";
        String Y = "AEDFHR";

        int result = longestCommonSequence.LCSequenceNaiveSolution(X, Y, X.length(), Y.length());
        System.out.println("Using Naive - " + result);

        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Using Memo - "
                + longestCommonSequence.LCSequenceMemoSolution(X, Y, m, n, dp));
    }
}
