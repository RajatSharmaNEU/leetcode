package GFG.Greedy;

import java.util.Arrays;
import java.util.List;

public class KnapSackWalker {

    public static int calculateMaximumProfit(List<Integer> cost, int x) {
        int MOD = 1000000007;
        int n = cost.size();

        // Create a DP table
        int[][] dp = new int[n + 1][x + 1];

        // Base cases: No items or no money
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // No profit with no money
        }
        for (int j = 0; j <= x; j++) {
            dp[0][j] = 0; // No profit with no items
        }

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                // If the item's cost is greater than the available budget, skip it
                if (cost.get(i - 1) > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Include or exclude the current item
                    int profitIncluding = (dp[i - 1][j - cost.get(i - 1)] + (int) Math.pow(2, i - 1)) % MOD;
                    int profitExcluding = dp[i - 1][j];
                    dp[i][j] = Math.max(profitIncluding, profitExcluding) % MOD;
                }
            }
        }

        return dp[n][x]; // Return the maximum profit at the end
    }

    public static void main(String[] args) {
        int result = calculateMaximumProfit(Arrays.asList(19, 78, 27, 18, 20), 25);
        System.out.println(result);
    }
}
