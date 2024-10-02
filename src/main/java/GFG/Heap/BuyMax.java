package GFG.Heap;

import java.util.PriorityQueue;

public class BuyMax {
    public static int findMax(int[] arr, int sum) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int count = 0;
        while (sum > 0) {
            sum = sum - pq.poll();
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 12, 5, 111, 200};
        System.out.println(findMax(arr, 10));
    }
}
