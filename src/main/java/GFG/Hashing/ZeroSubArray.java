package GFG.Hashing;

import java.util.HashSet;

// Consecutive sub array whose sum is zero
public class ZeroSubArray {
    public static boolean isSubArraySumZero(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if(hashSet.contains(sum) || sum == 0) {
                return true;
            } else {
                hashSet.add(sum);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 13, -3, -10, 5};
        int[] arr2 = new int[]{-1, 4, -3, 5, 1};
        int[] arr3 = new int[]{3, 1, -2, 5, 6};
        int[] arr4 = new int[]{5, 6, 0, 8};

        System.out.println(isSubArraySumZero(arr1));
        System.out.println(isSubArraySumZero(arr2));
        System.out.println(isSubArraySumZero(arr3));
        System.out.println(isSubArraySumZero(arr4));
    }
}
