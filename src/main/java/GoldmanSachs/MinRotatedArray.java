package GoldmanSachs;

import java.util.Arrays;

public class MinRotatedArray {
    public static int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int m = l + (h - l) / 2;

            if (nums[m] < nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(Arrays.toString(nums) + " min is at index " + l);
        return nums[l];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 1, 2};
        System.out.println(findMin(arr1));
        System.out.println(findMin(arr2));
    }
}
