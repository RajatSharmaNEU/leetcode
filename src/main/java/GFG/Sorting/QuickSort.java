package GFG.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSortLomuto(int[] arr, int low, int high) {
        if (low < high) {
            int p = Partition.lomuto(arr, low, high);
            quickSortLomuto(arr, low, p - 1);
            quickSortLomuto(arr, p + 1, high);
        }
    }

    public static void quickSortHoare(int[] arr, int low, int high) {
        if (low < high) {
            int p = Partition.hoare(arr, low, high);
            quickSortHoare(arr, low, p);
            quickSortHoare(arr, p + 1, high);
        }
    }

    public static void quickSortTailCallElimination(int[] arr, int low, int high) {
        while (low < high) {
            int p = Partition.lomuto(arr, low, high);

            // Sort small part
            if (p - low < high - p) {
                quickSortTailCallElimination(arr, low, p - 1); // Sort
                low = p + 1; // move to right part
            } else {
                quickSortTailCallElimination(arr, p + 1, high); // Sort
                high = p + 1; // move to left part
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{8, 4, 7, 9, 3, 6, 10, 5};
        System.out.println("Before - " + Arrays.toString(arr1));
        quickSortLomuto(arr1, 0, arr1.length - 1);
        System.out.println("After - " + Arrays.toString(arr1));

        int[] arr2 = new int[]{8, 4, 7, 9, 3, 6, 10, 5};
        System.out.println("Before - " + Arrays.toString(arr2));
        quickSortHoare(arr2, 0, arr2.length - 1);
        System.out.println("After - " + Arrays.toString(arr2));

        int[] arr3 = new int[]{8, 4, 7, 9, 3, 6, 10, 5};
        System.out.println("Before - " + Arrays.toString(arr3));
        quickSortTailCallElimination(arr3, 0, arr3.length - 1);
        System.out.println("After - " + Arrays.toString(arr3));
    }
}
