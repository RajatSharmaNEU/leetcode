package practice;

import java.util.Arrays;

public class QuickSort {
    static int cutOff = 16;

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort(int[] arr, int from, int to) {
        // Optimization 1
        // if (to <= from + 1) return;
        if (to <= from + cutOff) {
            Arrays.sort(arr, from, to);
            return;
        }

        // Optimization 2
        // int median = medianOf3(a, from, from + (to - from)/2, to);
        // swap(arr, from, median);

        int j = partition(arr, from, to);
        sort(arr, from, j);
        sort(arr, j + 1, to);
    }

    public static void threeWaySort(int[] arr, int from, int to) {
        if (to <= from) return;
        // partition(arr, from, to)
        int lt = from, gt = to - 1;
        int v = arr[from];
        int i = from;
        while (i <= gt) {
            if (arr[i] < v)
                swap(arr, lt++, i++);
            else if (arr[i] > v)
                swap(arr, i, gt--);
            else
                i++;
        }
        threeWaySort(arr, from, lt);
        threeWaySort(arr, gt + 1, to);
    }

    public static int partition(int[] arr, int from, int to) {
        int pivot = arr[from];
        int i = from;
        int j = to;

        while (true) {
            while (arr[++i] <= pivot)
                if (i == to - 1) break;

            while (arr[--j] >= pivot)
                if (j == from) break;

            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, from, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int[] input = new int[]{5, 3, 6, 9, 8, 4, 7, 2, 1};
        int[] input = new int[]{5, 5, 5, 5, 1, 2, 2, 3, 5};
        QuickSort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
