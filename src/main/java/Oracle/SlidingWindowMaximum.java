package Oracle;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // deque with index as value
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        int l = 0;

        for(int r = 0; r < n; r++) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[r]) {
                deque.removeLast();
            }

            deque.addLast(r);

            while(l > deque.getFirst()) {
                deque.removeFirst();
            }

            if(r + 1 >= k) {
                result[l] = nums[deque.getFirst()];
                l++;
            }

        }

        return result;

    }
}
