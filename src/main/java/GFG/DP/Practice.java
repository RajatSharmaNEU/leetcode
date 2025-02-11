package GFG.DP;

import java.util.Arrays;

public class Practice {
    public static int LIS(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().orElse(-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 8, 10};
        System.out.println(LIS(arr));
    }
}
