package practice;


import java.util.Arrays;

public class MergeSort {
    // 1. two sort call from 0 to mid and mid to end
    // 2. merge the result
    static int cutOff = 7;

    public static void sort(int[] a) {
        int[] auxArr = new int[a.length];
        sort(a, auxArr, 0, a.length);
    }

    public static void sort(int[] arr, int[] auxArr, int from, int to) {
        // Improvement 1 - Use Cutoff to switch to InsertionSort
        // if(from >= to-1) return;

         if (from >= to - cutOff) {
          Arrays.sort(arr, from, to);
          return;
         }

        int mid = from + ((to - from) / 2);
        System.out.println("from: " + from + " mid: " + mid + " to: " + to);
        sort(auxArr, arr, from, mid);
        sort(auxArr, arr, mid, to);

        // Improvement 2 - Avoid unnecessary merge call
        // if second array's first item is greater than first array last item
        if(arr[mid-1] < arr[mid]) {
            return;
        }

        merge(auxArr, arr, from, mid, to);
    }

    public static void merge(int[] auxArr, int[] arr, int from, int mid, int to) {
        //Improvement 3
        // Do not copy into auxiliary array
        // swap arr and arrAux in sort, sort
        // Copy arr into auxiliary array
//        for (int i = from; i < to; i++) {
//            auxArr[i] = arr[i];
//        }

        int i = from;
        int j = mid;

        for (int k = from; k < to; k++) {
            if (i >= mid) {
                arr[k] = auxArr[j++];
            } else if (j >= to) {
                arr[k] = auxArr[i++];
            } else if (auxArr[i] < auxArr[j]) {
                arr[k] = auxArr[i++];
            } else {
                arr[k] = auxArr[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
//        int[] input = new int[]{1, 2, 3, 4, 5, 11, 12, 13, 14, 15};
        MergeSort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
