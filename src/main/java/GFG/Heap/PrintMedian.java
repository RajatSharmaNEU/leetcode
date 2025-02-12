package GFG.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PrintMedian {
    public static void printMedian(int arr[]) {
        PriorityQueue<Integer> g = new PriorityQueue<>(); // minHeap
        PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap

        s.add(arr[0]);
//        System.out.println(s.peek());

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            if (s.size() > g.size()) {
                if (s.peek() > x) {
                    g.add(s.poll());
                    s.add(x);
                } else {
                    g.add(x);
                }
//                System.out.println((double) (s.peek() + g.peek()) / 2);
            } else {
                if (s.peek() >= x) {
                    s.add(x);
                } else {
                    g.add(x);
                    s.add(g.poll());
                }
//                System.out.println(s.peek());
            }
        }

        if(arr.length % 2 == 0) {
            System.out.println((double) (s.peek() + g.peek()) / 2);
        } else {
            System.out.println(s.peek());
        }
    }

    public static void printMedian2(int[] nums) {
        MedianFinderStream medianFinderStream = new MedianFinderStream();
        for (int i = 0; i < nums.length; i++) {
            medianFinderStream.addNum(nums[i]);
        }

        System.out.println(medianFinderStream.findMedian());
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 15, 10, 5, 8, 7, 16};
        PrintMedian.printMedian(arr);
        PrintMedian.printMedian2(arr);
    }
}
