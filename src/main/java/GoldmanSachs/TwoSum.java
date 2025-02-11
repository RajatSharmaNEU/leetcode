package GoldmanSachs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] BruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] MapApproach(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static int[] BinaryApproach(int[] nums, int target) {
        int[][] pairs = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        for(int i = 0; i < nums.length; i++) {
            int complement = target - pairs[i][0];
            int index = binarySearch(i+1, nums.length - 1, complement, pairs);

            if(index != -1) {
                return new int[]{pairs[i][1], pairs[index][1]};
            }
        }
        return new int[]{};
    }

    private static int binarySearch(int low, int high, int target, int[][] pairs) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pairs[mid][0] == target) {
                return mid;
            } else if (pairs[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 11, 7, 15};

        System.out.println("Brute Approach " + Arrays.toString(BruteForce(nums, 9)));
        System.out.println("Best Map Approach " + Arrays.toString(MapApproach(nums, 9)));
        System.out.println("Binary Approach " + Arrays.toString(BinaryApproach(nums, 9)));
    }
}
