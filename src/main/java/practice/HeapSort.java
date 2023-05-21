package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HeapSort {

    public static void test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.keySet().toArray();
    }

    public static void sort(int[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) sink(a, k, N);
        while (N > 1) {
            swap(a, 1, N);
            sink(a, 1, --N);
        }
    }

    public static void sink(int[] a, int k, int N) {
        while (firstChild(k) <= N) {
            int j = firstChild(k);
            if (j < N && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            swap(a, k, j);
            k = j;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = tmp;
    }

    public static boolean less(int[] arr, int i, int j) {
        return arr[i-1] < arr[j-1];
    }

    public static int firstChild(int k) {
        return (k * 2);
    }

    public static void main(String[] args) {
//        int[] input = new int[]{5, 3, 6, 9, 8, 4, 7, 2, 1};
        int[] input = new int[]{5, 5, 5, 5, 1, 2, 2, 3, 5};
        System.out.println("Heap Sort");
        HeapSort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}