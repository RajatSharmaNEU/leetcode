package GFG.Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void countSort(int[] arr, int k) {
        int[] count = new int[k];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Optimization for General Purpose - when items are object or other
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void naiveCountSort(int[] arr, int k) {
        int[] count = new int[k];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int index = 0;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 4, 1, 0, 1}; // [1, 3, 0, 0, 2]
        int[] arr2 = new int[]{5, 6, 5, 2};

//        System.out.println(Arrays.toString(arr1));
//        naiveCountSort(arr1, 5);
//        System.out.println(Arrays.toString(arr1));

        System.out.println(Arrays.toString(arr1));
        countSort(arr1, 5);
        System.out.println(Arrays.toString(arr1));

        System.out.println(Arrays.toString(arr2));
        countSort(arr2, 10);
        System.out.println(Arrays.toString(arr2));
    }
}
