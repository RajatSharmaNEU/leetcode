package GFG.DP;

// 0-1 KnapSack
// Find max value possible consider weight limit as constraint
// understand in terms of Maximize Grades considering time-limit as constraint
public class KnapSack {
    private int knapSackRecursive(int[] weights, int[] values, int weightLimit, int endIndex) {
        if (endIndex < 0 || weightLimit <= 0) {
            return 0;
        }
        if (weights[endIndex] > weightLimit) {
            return knapSackRecursive(weights, values, weightLimit, endIndex - 1);
        }

        return Math.max(
                // ignore current iteration and expect in further
                knapSackRecursive(weights, values, weightLimit, endIndex - 1),
                // consider current iteration
                values[endIndex] + knapSackRecursive(weights, values, weightLimit - weights[endIndex], endIndex - 1)
        );
    }

    // n is no of elements in weight/values array
    // W is the weight limit
    private int knapSackDP(int[] weights, int[] values, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // case when W is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // case when no of elements is zero
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) { // Represent no of elements to be consider
            for (int j = 1; j <= W; j++) { // represent WeightExpected
                // if current weight is less than provided weight
//                if (j < weights[i - 1]) { // if current weight is less than provided weight
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(
//                            values[i - 1] + dp[i - 1][j - weights[i - 1]],
//                            dp[i - 1][j]
//                    );
//                }

                // Carry value
                dp[i][j] = dp[i - 1][j];
                if (j >= weights[i - 1]) { // if current weight is greater or equal to provided weight
                     dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i][j]);
                }

            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values = new int[]{10, 40, 30, 50};
        int[] weights = new int[]{5, 4, 6, 3};
        int weightLimit = 10;

        KnapSack knapSack = new KnapSack();
        System.out.println(knapSack.knapSackRecursive(weights, values, weightLimit, weights.length - 1));
        System.out.println(knapSack.knapSackDP(weights, values, weightLimit, weights.length));
    }
}
