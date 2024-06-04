package GFG.DP;

public class MaximumCuts {
    private int maxCutsRecursive(int n, int a, int b, int c) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        int cutA = maxCutsRecursive(n - a, a, b, c);
        int cutB = maxCutsRecursive(n - b, a, b, c);
        int cutC = maxCutsRecursive(n - c, a, b, c);
        int res = Math.max(Math.max(cutA, cutB), cutC);

        if(res == -1) {
            return -1;
        }

        return 1 + res;
    }

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

    public static void main(String[] args) {
        MaximumCuts maximumCuts = new MaximumCuts();
//        System.out.println(maximumCuts.findMaxCutsUsingMatrix(new int[]{1, 2, 3}, 5));
        System.out.println(maximumCuts.findMaxCutsUsingArray(5, 1, 2, 3));
        System.out.println(maximumCuts.maxCutsRecursive(17, 10, 11, 3));
//        System.out.println(maximumCuts.findMaxCutsUsingArray(17, 10, 11, 3));
    }
}
