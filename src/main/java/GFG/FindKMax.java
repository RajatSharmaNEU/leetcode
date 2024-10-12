package GFG;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindKMax {

    // Time Complexity - O(n ^ 2)
    public static void findKMaxNaive(int[] arr, int k) {
        for (int i = 0; i <= arr.length - k; i++) {
            int currMax = arr[i];
            for (int j = i; j < k + i; j++) {
                currMax = Math.max(currMax, arr[j]);
            }
            System.out.println(currMax);
        }
    }

    // Time Complexity - O(2n) -> O(n)
    public static void findKMax(int[] arr, int k) {
        // use deque to maintain index of - Max at peek and min at end
        Deque<Integer> deque = new ArrayDeque<>();

        // Step 1 - Maintain List of K element
        // If list is not empty, remove element smaller than new element
        // Step 2 -
        // if new element index - peek element index > k -- remove peek
        // if new element > tail, keep on removing last element


        // remove element whose value is less then new element
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < arr.length; i++) {
            // Print Peek element
            System.out.println(arr[deque.peek()]);

            // remove element who is not in range of k window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }

            // remove element whose value is less then new element
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Print Peek element
        System.out.println(arr[deque.peek()]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 40, 30, 10, 60};
        System.out.println("Using Naive");
        findKMaxNaive(arr, 3);
        System.out.println("Using Deque");
        findKMax(arr, 3);
    }
}
