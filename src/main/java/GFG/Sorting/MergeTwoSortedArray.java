package GFG.Sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0, n = arr1.length, m = arr2.length;

        int[] result = new int[m + n];
        int index = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result[index++] = arr1[i++];
            } else {
                result[index++] = arr2[j++];
            }
        }

        while (i < n) {
            result[index++] = arr1[i++];
        }

        while (i < n) {
            result[index++] = arr1[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 50};
        int[] arr2 = new int[]{5, 50, 50};

        int[] result = mergeTwoArray(arr1, arr2);

        System.out.println(Arrays.toString(result));
    }
}
