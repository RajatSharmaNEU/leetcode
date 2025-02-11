package Oracle;

import java.util.Arrays;

public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    public static int minJumpCount(int[] nums) {
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
        CanJump canJumpBoolean = new CanJump();
        System.out.println(canJumpBoolean.canJump(jumps));
        System.out.println(canJumpBoolean.minJumpCount(jumps));
        System.out.println(canJumpBoolean.canJump(new int[]{3,2,1,0,4}));
    }
}
