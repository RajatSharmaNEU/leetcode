package GFG.Hashing;

import java.util.Arrays;

public class CommonSumSubBinaryArray {
    public static int longestCommonSumSubArrayNaive(int[] arr1, int[] arr2) {
        int n = arr1.length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = i; j < n; j++) {
                sum1 = sum1 + arr1[j];
                sum2 = sum2 + arr2[j];

                if(sum1 == sum2) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }

    public static int longestCommonSumSubArray(int[] arr1, int[] arr2) {
        int n = arr1.length;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = arr1[i] - arr2[i];
        }

        System.out.println(Arrays.toString(temp));

        return LongestSumSubArray.findLongestSumSubArray(temp, 0);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 0, 0, 0, 0};
        int[] arr2 = new int[]{1, 0, 1, 0, 0, 1};

        System.out.println(longestCommonSumSubArrayNaive(arr1, arr2));
        System.out.println(longestCommonSumSubArray(arr1, arr2));
    }
}
