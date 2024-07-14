package GFG.Sorting;

import java.util.Arrays;

public class ChocolateDistribution {
    public static int minDiff(int[] arr, int m) {
        if (m > arr.length) {
            return -1;
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - m; i++) {
            res = Math.min(res, arr[i + m - 1] - arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 3, 1, 8, 9, 12, 56};
        int[] arr2 = new int[]{3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(minDiff(arr1, 3));
        System.out.println(minDiff(arr2, 5));
    }
}
