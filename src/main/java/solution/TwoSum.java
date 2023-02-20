package solution;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/submissions/901326906/
public class TwoSum {
    public static int[] getTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(hashMap.containsKey(complement) && hashMap.get(complement) !=i) {
                return new int[] {hashMap.get(complement), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }
}
