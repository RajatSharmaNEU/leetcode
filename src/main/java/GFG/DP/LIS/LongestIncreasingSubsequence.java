package GFG.DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int countLISBinary(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int idx = Collections.binarySearch(temp, nums[i]);
                System.out.println(idx);
                if (idx < 0) idx = -idx - 1; // Get insertion point
                temp.set(idx, nums[i]);
                System.out.println(Arrays.toString(temp.toArray()));
            }
        }
        return temp.size();
    }


    // O(n^2) - LIS
    private int countLISNaive(int[] arr) {
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        int result = Arrays.stream(dp).max().orElse(-1);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};


        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
//        System.out.println(lis.countLISNaive(arr));
        System.out.println(lis.countLISBinary(arr));
    }
}
