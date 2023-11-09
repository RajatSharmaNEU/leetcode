package GFG.DP;

public class MinCoinsForValue {
    private int minCoinsRecursive(int sum, int[] coins) {
        if(sum == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= sum) {
                res = Math.min(res, 1 + minCoinsRecursive(sum-coins[i], coins));
            }
        }

        return res;
    }

    private int minCoinsDP(int sum, int[] coins) {
        int[] dp = new int[sum + 1];

        for (int i = 0; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    // Optimized
                    int subResult = 1 + dp[i - coins[j]];
                    if(subResult != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    }

                    // non-optimized
                    //dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        MinCoinsForValue minCoinsForValue = new MinCoinsForValue();
        System.out.println(minCoinsForValue.minCoinsRecursive(30, new int[]{25, 10, 5}));
        System.out.println(minCoinsForValue.minCoinsDP(30, new int[]{25, 10, 5}));
    }
}
