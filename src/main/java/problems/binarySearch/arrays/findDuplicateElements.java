package problems.binarySearch.arrays;

import java.util.*;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class findDuplicateElements {
    public static List<Integer> Solution(int[] nums) {
//        boolean[] elementExist = new boolean[nums.length + 1];
//        List<Integer> duplicates = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (elementExist[nums[i]]) duplicates.add(nums[i]);
//            elementExist[nums[i]] = true;
//        }
//
//        return duplicates;

        List<Integer> duplicate = new ArrayList<>();
        for(int num: nums) {
            num = Math.abs(num);
            if(nums[num-1] > 0) nums[num-1] = nums[num-1] * -1;
            else duplicate.add(num);
        }
        System.gc();
        return duplicate;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = new int[]{1, 1, 2};
        int[] nums3 = new int[]{1};
        System.out.println(Solution(nums1));
        System.out.println(Solution(nums2));
        System.out.println(Solution(nums3));
    }

}
