package GoldmanSachs;

public class CanJump {
    public static boolean canJump(int[] nums) {
        int target = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }

        return target == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
