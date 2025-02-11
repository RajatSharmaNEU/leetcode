package GoldmanSachs;

public class MinValStepByStep {

    public static int minStartValue(int[] nums) {
        int startValue = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= 0) {
                startValue = startValue + Math.abs((sum + nums[i]));
                sum = 0;
            } else {
                sum = sum + nums[i];
            }

        }

        return startValue;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(minStartValue(nums));
    }
}
