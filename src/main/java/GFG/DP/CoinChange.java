package GFG.DP;

public class CoinChange {
    private int countCoinsDP(int coins[], int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    private int countCoinsNaive(int[] coins, int sum, int index) {
        if (sum == 0) {
            return 1;
        }

        if (index == coins.length || sum < 0) {
            return 0;
        }

        return countCoinsNaive(coins, sum - coins[index], index) + countCoinsNaive(coins, sum, index + 1);
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        // 1111, 112, 13, 22,
        int sum = 4;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.countCoinsNaive(coins, sum, 0));
        System.out.println(coinChange.countCoinsDP(coins, sum));
    }
}
