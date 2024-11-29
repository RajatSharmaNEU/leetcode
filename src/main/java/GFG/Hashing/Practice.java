package GFG.Hashing;

import java.util.HashMap;

public class Practice {
    public static int findLongestSumSubArray(int[] arr, int sum) {
        // consecutive numbers sum as sum
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int currSum = 0, maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if(currSum == sum) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if(hashMap.containsKey(currSum - sum)) {
                maxLength = Math.max(maxLength, i - hashMap.get(currSum - sum));
            } else {
                hashMap.put(currSum, i);
            }


        }

        return maxLength;
    }

    public static int longestSubArray(int[] arr) {
//        return findLongestSumSubArray(Arrays.stream(arr).map(p -> p == 0 ? -1: 1).toArray(), 0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        return findLongestSumSubArray(arr, 0);
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 0, 1, 1, 1, 0, 0};
        int[] arr2 = new int[]{1, 1, 1, 1};
        int[] arr3 = new int[]{0, 0, 1, 1, 1, 1, 1, 0, 0};
        int[] arr4 = new int[]{1, 0, 1, 1, 1, 0, 0};

        System.out.println(longestSubArray(arr1));
        System.out.println(longestSubArray(arr2));
        System.out.println(longestSubArray(arr3));
        System.out.println(longestSubArray(arr4));
    }
}
