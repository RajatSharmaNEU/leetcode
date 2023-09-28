package problems.binarySearch.sorting;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int Solution(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            int count = map.getOrDefault(num, 0) + 1;
//            if (count > nums.length / 2) {
//                return num;
//            } else {
//                map.put(num, count);
//            }
//        }
//        return -1;
        int prevNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == prevNum) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    prevNum = nums[i];
                    count = 1;
                }
            }
        }
        return prevNum;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{3, 2, 3};
        int[] input2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(Solution(input1));
        System.out.println(Solution(input2));
    }
}
