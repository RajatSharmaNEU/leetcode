package GFG.DP;

import java.util.Arrays;

public class Practice {
    private int LISNaive(int[] arr) {
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 8, 10};
        Practice practice = new Practice();
        System.out.println(practice.LISNaive(arr));
    }
}
