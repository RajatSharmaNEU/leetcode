package problems.binarySearch;

import java.util.*;

public class KSmallestSumPair {
    public static List<List<Integer>> Solution(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
//
//        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
//                (a, b) -> (a.get((0) + a.get(1)) - (b.get(0) + b.get(1)))
//        );
//
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                pq.add(Arrays.asList(nums1[i], nums2[j]));
//            }
//        }
//
//        while (k > 0 && !pq.isEmpty()) {
//            result.add(pq.poll());
//            k--;
//        }


        // First Approach
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {
                List<Integer> curr = new ArrayList<>();
                curr.add(nums1[i]);
                curr.add(nums2[j]);
                result.add(curr);
            }
        }

        result.sort((pair1, pair2) -> {
            return (pair1.get(0) + pair1.get(1)) - (pair2.get(0) + pair2.get(1));
        });

        // Unclear solution
//        int total = nums1.length * nums2.length;
//        if (total < k) {
//            k = total;
//        }
//
//        int[] idx = new int[nums1.length];//track each element's cursor in nums2
//        while (k > 0) {
//            int min = Integer.MAX_VALUE;
//            int minIdx = -1;
//            for (int i = 0; i < nums1.length; i++) {
//                if (idx[i] < nums2.length && nums1[i] + nums2[idx[i]] < min) {
//                    minIdx = i;
//                    min = nums1[i] + nums2[idx[i]];
//                }
//            }
//                List<Integer> curr = new ArrayList<>();
//                curr.add(nums1[minIdx]);
//                curr.add(nums2[idx[minIdx]]);
//                result.add(curr);
//
//            idx[minIdx]++;
//            k--;
//        }
//
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Solution(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println(Solution(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(Solution(new int[]{1, 2}, new int[]{3}, 3));
        System.out.println(Solution(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
    }
}
