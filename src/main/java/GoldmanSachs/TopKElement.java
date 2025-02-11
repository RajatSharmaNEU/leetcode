package GoldmanSachs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKElement {
    public static int[] findTopKElements(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key: map.keySet()) {
            pq.add(key);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(findTopKElements(nums, 2)));
    }
}
