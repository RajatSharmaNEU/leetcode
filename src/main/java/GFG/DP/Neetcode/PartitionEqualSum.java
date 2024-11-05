package GFG.DP.Neetcode;

import java.util.Arrays;

public class PartitionEqualSum {
    static public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];

        return dfs(0, nums, target, dp);
    }

    static public boolean dfs(int i, int[] nums, int target, Boolean[][] dp) {
        if (target < 0) {
            return false;
        }

        if (i == nums.length) {
            return target == 0;
        }

        if (dp[i][target] != null) {
            return dp[i][target];
        }

        dp[i][target] = dfs(i + 1, nums, target, dp) || dfs(i + 1, nums, target - nums[i], dp);

        return dp[i][target];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 2, 1, 1};
        int[] arr2 = new int[]{1, 5, 11, 5};

        System.out.println(canPartition(arr1));
        System.out.println(canPartition(arr2));
    }
}
