package GFG.String.NeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {
    public static int[] findMax(int[] nums, int k) {
        int l = 0, r = 0;
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // hold index

        while (r < nums.length) {

            // add new item in sliding queue but remove all element less than curr
            // remove less element
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);

            // remove all entry whose index is less than left (out of bound)
            while (l > deque.getFirst()) {
                deque.removeFirst();
            }

            // add to output only if sliding window completes --> r+1 >= k
            if(r+1 >= k) {
                output[l] = nums[deque.getFirst()];
                l++;
            }
            r++;
        }

        return output;
    }

    public static void findMaxValueInWindow(int[] arr, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // Holds index of element
        int l = 0;

        for (int r = 0; r < arr.length; r++) {
            while (!deque.isEmpty() && arr[deque.getLast()] < arr[r]) {
                deque.removeLast();
            }
            deque.addLast(r);

            while (deque.getFirst() < l) {
                deque.removeFirst();
            }

            if(r >= k -1) {
                System.out.print(arr[deque.getFirst()]);
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(findMax(arr, k)));
        findMaxValueInWindow(arr, k);
    }
}
