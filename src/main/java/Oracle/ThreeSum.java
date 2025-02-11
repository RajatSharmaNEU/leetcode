package Oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // sort - n.logn
        // for loop - distinct element ->
        // binary search to find sum

        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            left = i + 1;
            right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};

        List<List<Integer>> res = threeSum(nums);

        for(List<Integer> curr: res) {
            System.out.println(curr.toString());
        }
    }

}
