package GFG.DP;

public class MaximumCuts {
    private int maxCutsRecursive(int n, int a, int b, int c) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        return maxCutsRecursive(n - a, a, b, c) + maxCutsRecursive(n - b, a, b, c) + maxCutsRecursive(n - c, a, b, c);
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

//    private int maxCutsDP(int sum, int a, int b, int c) {
//        int[] dp = new int[sum + 1];
//        for (int i = 0; i <= sum; i++) { // i represent sum
//            if(i >= a) {
//                dp[i] = Math.max(dp[i], 1 + dp[i-a]);
//            }
//
//            if(i >= b) {
//                dp[i] = Math.max(dp[i], 1 + dp[i-b]);
//            }
//
//            if(i >= c) {
//                dp[i] = Math.max(dp[i], 1 + dp[i-c]);
//            }
//        }
//
//        return dp[sum];
//    }


    public static void main(String[] args) {
        MaximumCuts maximumCuts = new MaximumCuts();
//        System.out.println(maximumCuts.findMaxCutsUsingMatrix(new int[]{1, 2, 3}, 5));
        System.out.println(maximumCuts.findMaxCutsUsingArray(5, 1, 2, 3));
        System.out.println(maximumCuts.maxCutsRecursive(17, 10, 11, 3));
//        System.out.println(maximumCuts.findMaxCutsUsingArray(17, 10, 11, 3));
    }
}
