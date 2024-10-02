package GFG.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// Nearly Sorted Array
// Given an array of N elements, where each element is at most K away from its target position.
// element at ith position could be in range of k-i to k+i away.
public class SortKSortedArray {

    public static void sortK(int[] arr, int k) {
        // create pq with k element as least element can be keep at first position in output array
        // now one by one add new element in pq and take out small element n put it in output array.

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        int index = 0;
        for (int i = k+1; i < arr.length; i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        sortK(arr, k);
        System.out.println("Sorted Array is " + Arrays.toString(arr));

    }
}
