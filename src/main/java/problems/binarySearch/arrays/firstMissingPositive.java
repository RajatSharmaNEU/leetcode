package problems.binarySearch.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class firstMissingPositive {
    public static int Solution(int[] nums) {
        boolean[] mapper = new boolean[nums.length + 1];

        for (int num: nums) {
            if (num > 0 && num <= nums.length) {
                mapper[num] = true;
            }
        }

        for (int i = 1; i < mapper.length; i++) {
            if (!mapper[i]) return i;
        }

        return mapper.length;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 0};
        int[] input2 = new int[]{3, 4, -1, 1};
        int[] input3 = new int[]{7, 8, 9, 11, 12};
        int[] input4 = new int[]{1};
        int[] input5 = new int[]{2, 1};
        System.out.println(Solution(input1));
        System.out.println(Solution(input2));
        System.out.println(Solution(input3));
        System.out.println(Solution(input4));
        System.out.println(Solution(input5));
    }
}
