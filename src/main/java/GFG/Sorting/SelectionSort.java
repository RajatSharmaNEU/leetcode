package GFG.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            // Swap
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {90, 80, 90, 25};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
