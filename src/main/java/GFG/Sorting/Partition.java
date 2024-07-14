package GFG.Sorting;

import java.util.Arrays;

public class Partition {
    public static void naive(int[] arr, int p) {
        int[] temp = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr[p]) {
                temp[index++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[p]) {
                temp[index++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(temp));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int lomuto(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static int hoare(int[] arr, int low, int high) {
        int pivot = arr[low];

        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 8, 6, 12, 10, 7};
        int[] arr2 = new int[]{5, 3, 8, 4, 2, 7, 1, 10};
        System.out.println("arr1 - " + Arrays.toString(arr1));
//        naive(arr1, 5);

        int lomutoIndex = lomuto(arr1, 0, arr1.length - 1);
        System.out.println("LomutoIndex " + lomutoIndex);
        System.out.println(Arrays.toString(arr1));

        System.out.println("arr2 - " + Arrays.toString(arr2));
        int hoareIndex = hoare(arr2, 0, arr2.length - 1);
        System.out.println("HoareIndex " + hoareIndex);
        System.out.println(Arrays.toString(arr2));
    }
}
