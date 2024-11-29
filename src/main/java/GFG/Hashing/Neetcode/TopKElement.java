package GFG.Hashing.Neetcode;

import java.util.*;

public class TopKElement {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // count each item
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // convert map into list to sort and find top k element;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 1, 2, 2, 3};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{-1,-1};
        System.out.println(Arrays.toString(topKFrequent(arr1, 2)));
        System.out.println(Arrays.toString(topKFrequent(arr2, 1)));
        System.out.println(Arrays.toString(topKFrequent(arr3, 1)));
    }
}
