package GFG.DP;

public class MaximumCuts {
    private int findMaxCutsUsingArray(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0) dp[i] = Math.max(dp[i], dp[i - a]);
            if (i - b >= 0) dp[i] = Math.max(dp[i], dp[i - b]);
            if (i - c >= 0) dp[i] = Math.max(dp[i], dp[i - c]);

            if (dp[i] != -1) dp[i]++;
        }

        return dp[n];
    }

    private int findMaxCutsUsingMatrix(int cuts[], int sum) {
        int n = cuts.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (cuts[i - 1] <= j) {
                    dp[i][j] = dp[i][j] + dp[i][j - cuts[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        MaximumCuts maximumCuts = new MaximumCuts();
        System.out.println(maximumCuts.findMaxCutsUsingMatrix(new int[]{1, 2, 3}, 5));
        System.out.println(maximumCuts.findMaxCutsUsingArray(5, 1, 2, 3));
    }
}
