package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    public static void dualPivot(int[] arr, int from, int to) {
        if (to <= from) return;

        int lo = from;
        int hi = to - 1;

        //helper.swapConditional(arr, lo, hi);
        if(arr[lo] > arr[hi]) {
            int temp  = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
        }

        int lt = lo + 1;
        int gt = hi - 1;
        int i = lt;
        int v1 = arr[lo];
        int v2 = arr[hi];

        while (i <= gt) {
            int x = arr[i];
            if (x < v1) swap(arr, lt++, i++);
            else if (x > v2) swap(arr, i, gt--);
            else i++;
        }

        swap(arr, lo, --lt);
        swap(arr, hi, ++gt);

        dualPivot(arr, lo, lt);
        dualPivot(arr, lt + 1, gt);
        dualPivot(arr, gt + 1, hi + 1);
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
        int[] input1 = new int[]{5, 3, 6, 9, 8, 4, 7, 2, 1};
        int[] input2 = new int[]{5, 3, 6, 9, 8, 4, 7, 2, 1};
        int[] input3 = new int[]{5, 3, 6, 9, 8, 4, 7, 2, 1} ;// new int[]{5, 5, 5, 5, 1, 2, 2, 3, 5};
        System.out.println("Basic Sort");
        QuickSort.sort(input1);
        System.out.println(Arrays.toString(input1));


        System.out.println("Three-way Sort");
        QuickSort.threeWaySort(input2, 0, input2.length);
        System.out.println(Arrays.toString(input2));


        System.out.println("Dual Pivot Sort");
        QuickSort.dualPivot(input3, 0, input3.length);
        System.out.println(Arrays.toString(input3));

    }
}
