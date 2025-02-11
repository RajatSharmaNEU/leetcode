package GoldmanSachs;

import java.util.HashMap;
import java.util.Map;

public class ContiguousSubArraySum {
    public static int subarraySum(int[] nums, int k) {
        // Brute Force
        /*
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;

            for(int j = i; j < nums.length; j++) {
                sum = sum + nums[j];

                if(sum == k) {
                    res++;
                }
            }
        }

        return res;
        */

        // Use Prefix Map
        Map<Integer, Integer> map = new HashMap<>(); // currSum, count
        int currSum = 0;
        int res = 0;

        map.put(0, 1);

        for (int num : nums) {
            currSum = currSum + num;
            int diff = currSum - k;
            res = res + map.getOrDefault(diff, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 1, 1, 1, 1};
        System.out.println(subarraySum(nums, 3));
    }
}
