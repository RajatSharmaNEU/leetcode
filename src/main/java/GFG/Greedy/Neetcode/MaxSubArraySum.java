package GFG.Greedy.Neetcode;

public class MaxSubArraySum {

    public static int maxSubArrayNaive(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        for(int i = 0; i < nums.length; i++) {
            int curr = 0;
            for(int j = i; j < nums.length; j++) {
                curr = curr + nums[j];
                res = Math.max(res, curr);
            }
        }

        return res;
    }

    // Kadane Algorithm
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int prevSum = nums[0];

        for (int num: nums) {
            if(prevSum < 0) {
                prevSum = 0;
            }
            max = Math.max(max, prevSum + num);
            prevSum += num;
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr1 = new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(maxSubArrayNaive(arr));
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray(arr1));
    }
}
