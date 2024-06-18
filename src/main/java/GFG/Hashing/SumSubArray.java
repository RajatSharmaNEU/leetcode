package GFG.Hashing;

import java.util.HashSet;

// Consecutive sub array whose sum matches
public class SumSubArray {
    public static boolean isSumSubArray(int[] arr, int sum) {
        HashSet<Integer> hashSet = new HashSet<>();
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];

            if (hashSet.contains(currSum - sum) || currSum == sum) {
                return true;
            }

            hashSet.add(currSum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 8, 6, 13, 3, -1};
        int[] arr2 = new int[]{15, 2, 8, 10, -5, -8, 6};
        int[] arr3 = new int[]{3, 2, 5, 6};

        System.out.println(isSumSubArray(arr1, 22));
        System.out.println(isSumSubArray(arr2, 3));
        System.out.println(isSumSubArray(arr3, 10));
    }
}
