package GoldmanSachs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMax {
    public static int findThirdMax(int[] nums) {
        // minHeap but poll if size > 3
        // if minHeap size < 3 ~ poll till size != 1

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                pq.offer(num);
                set.add(num);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }

        if (pq.size() < 3) {
            while (pq.size() != 1) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {3, 2, 1};
        int[] arr2 = new int[] {2, 1};
        System.out.println(findThirdMax(arr1));
        System.out.println(findThirdMax(arr2));
    }
}
