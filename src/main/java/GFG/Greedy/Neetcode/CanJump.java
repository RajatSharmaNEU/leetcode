package GFG.Greedy.Neetcode;

public class CanJump {
    public static boolean canJumpDP(int[] nums) {
        int n = nums.length;
        boolean[] jump = new boolean[n];
        jump[n - 1] = true;

        for(int i = n-2; i >= 0; i--) {
            for(int j = 1; j <= nums[i]; j++) {
                if(jump[i + j] == true) {
                    jump[i] = true;
                }
            }
        }

        return jump[0];
    }

    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    public static void main(String[] args) {
        int[] jumps = new int[] {2,3,1,1,4};
        System.out.println(canJumpDP(jumps));
        System.out.println(canJump(jumps));
    }
}
