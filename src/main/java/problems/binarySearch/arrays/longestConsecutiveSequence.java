package problems.binarySearch.arrays;

import java.util.Arrays;

public class longestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) return 0;
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
        }

        return Math.max(count, maxCount);
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] input2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] input3 = new int[]{1,2,0,1};
        System.out.println(longestConsecutive(input1));
        System.out.println(longestConsecutive(input2));
        System.out.println(longestConsecutive(input3));
    }
}
