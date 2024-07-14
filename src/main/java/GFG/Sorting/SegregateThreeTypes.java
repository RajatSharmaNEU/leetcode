package GFG.Sorting;

import java.util.Arrays;

public class SegregateThreeTypes {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void hoareSegregation012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) { //&& low <= mid
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void hoareSegregationPivot(int[] arr, int pivot) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] < pivot) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == pivot) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void hoareSegregationRange(int[] arr, int[] pivot) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] < pivot[0]) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] > pivot[1]) {
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 2, 0, 1, 2, 0, 1, 2};
        int[] arr2 = new int[]{2, 1, 2, 20, 10, 20, 1};
        int[] arr3 = new int[]{10, 5, 6, 3, 20, 9, 40};
        System.out.println("Initial - " + Arrays.toString(arr1));
        hoareSegregation012(arr1);
        System.out.println("hoareSegregation012 - " + Arrays.toString(arr1));

        System.out.println("Initial - " + Arrays.toString(arr2));
        hoareSegregationPivot(arr2, 2);
        System.out.println("hoareSegregationPivot - " + Arrays.toString(arr2));

        System.out.println("Initial - " + Arrays.toString(arr3));
        hoareSegregationRange(arr3, new int[]{5, 10});
        System.out.println("hoareSegregationRange - " + Arrays.toString(arr3));

    }
}
