package OA;

public class palindromicSequence {

    public static int product(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        // stage one: from bottom to up, obtain the palindromic subsequence numbers in each substring
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        // second stage: traverse the matrix, update maxProduct in each iteration
        // outer loop: traverse string s from i to length
        // inner loop: divide current s[i : length - 1] by j to left and right part, then obtain current product by multiply
        // palindromic numbers in s[i : j] and s[j : length - 1], which correspond to dp[i][j] and dp[j][length - 1], also update maxProduct
        int maxProduct = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                maxProduct = Math.max(maxProduct, dp[i][j] * dp[j + 1][length - 1]);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(product("attract"));
        System.out.println(product("axbawbaseksqke"));
    }
}
