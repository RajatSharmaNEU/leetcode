package GFG.DP;

// You have to pick 1 corner coin and maximize coins sum to win
// Total coins are even
public class OptimalCoinPickingGame {

    private int calculate1(int[] coins, int i, int j, int sum) {
        if (j == i + 1) {
            return Math.max(coins[j], coins[i]);
        }

        return Math.max(
                // here calculate give opponent best coin
                sum - calculate1(coins, i, j - 1, sum - coins[j]),
                sum - calculate1(coins, i + 1, j, sum - coins[i])
        );
    }

    private int strategyRecursive1(int[] coins) {
        int sumOfCoins = 0;

        for (int i = 0; i < coins.length; i++) {
            sumOfCoins = sumOfCoins + coins[i];
        }

        return calculate1(coins, 0, coins.length - 1, sumOfCoins);
    }

    private int strategyRecursive2(int[] coins, int i, int j) {
        if (i + 1 == j) {
            return Math.max(coins[i], coins[j]);
        }

        return Math.max(
                coins[i] + Math.min(strategyRecursive2(coins, i + 2, j), strategyRecursive2(coins, i + 1, j - 1)),
                coins[j] + Math.min(strategyRecursive2(coins, i + 1, j - 1), strategyRecursive2(coins, i, j - 2))
        );
    }

    private int strategyDP(int[] coins, int n) {
        int[][] dp = new int[n][n];

        for (int i = 0; i < n-1; i++) {
            dp[i][i + 1] = Math.max(coins[i], coins[i + 1]);
        }

        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(
                        coins[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        coins[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2])
                );
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{20, 5, 4, 6};
        OptimalCoinPickingGame optimalCoinPickingGame = new OptimalCoinPickingGame();
        System.out.println(optimalCoinPickingGame.strategyRecursive1(coins));
        System.out.println(optimalCoinPickingGame.strategyRecursive2(coins, 0, coins.length - 1));
        System.out.println(optimalCoinPickingGame.strategyDP(coins, coins.length));
    }
}
