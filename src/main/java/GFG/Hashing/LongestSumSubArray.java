package GFG.Hashing;

import java.util.HashMap;

// longest consecutive sub array whose sum match
public class LongestSumSubArray {
    public static int findLongestSumSubArray(int[] arr, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int currSum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum == sum) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (hashMap.containsKey(currSum - sum)) {
                maxLength = Math.max(maxLength, i - hashMap.get(currSum - sum));
            } else {
                hashMap.put(currSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 8, -4, -4, 9, -2, 2}; // 5, 13, 9, 5,
        int[] arr2 = new int[]{3, 1, 0, 1, 8, 2, 3, 6}; // 3, 4, 4, 5, 13, 15, 18, 24
        int[] arr3 = new int[]{8, 3, 7}; // 8, 11, 18

        System.out.println(findLongestSumSubArray(arr1, 0));
        System.out.println(findLongestSumSubArray(arr2, 5));
        System.out.println(findLongestSumSubArray(arr3, 15));
    }
}
