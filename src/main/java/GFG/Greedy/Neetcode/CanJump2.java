package GFG.Greedy.Neetcode;

import java.util.Arrays;

public class CanJump2 {
    public static int canJump(int[] nums) {
        // Step 1 - Forward Loop from i to n - 1
        // Step 2 - Backward Loop from j = i + nums[i] to i ~
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, 100000);
        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--) {
            for(int j = i + 1; j <= i + nums[i]; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }

        return dp[0];
    }

    public static int canJump2(int[] nums) {
        // Step 1 - Forward Loop from i to n - 1
        // Step 2 - Backward Loop from j = i + nums[i] to i ~
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, 100000);
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(j + nums[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[n - 1];
    }
    public static void main(String[] args) {
        int[] jumps = new int[] {2,3,1,1,4};

        System.out.println(canJump(jumps));
        System.out.println(canJump2(jumps));
    }
}
