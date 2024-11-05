package GFG.DP.Neetcode;

public class AlternateHouseRobberCircular {
    static String s = new String();
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        return Math.max(
                robHelper(nums, 0, n - 2), // from 0 to second last
                robHelper(nums, 1, n - 1) //  from 1 to last
        );
    }

    // modified rob method from Alternate House Robber to consider start index
    public static int robHelper(int[] nums, int start, int end) {
        int n = end - start + 1;

        if (n == 1) return nums[start];
        if (n == 2) return Math.max(nums[start], nums[start + 1]);

        int[] dp = new int[n];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[n - 1];

    }

//    public static int rob(int[] nums) {
//        int n = nums.length;
//
//        if(n == 1) return nums[0];
//        if(n == 2) return Math.max(nums[0], nums[1]);
//
//        int[] dp = new int[n];
//
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for(int i = 2; i < n; i++) {
//            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
//        }
//
//        return dp[n - 1];
//    }


    public static void main(String[] args) {
        int[] house = new int[]{2, 3, 2};
        System.out.println(rob(house));
    }
}
