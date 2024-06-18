package GFG.Hashing;

import java.util.HashSet;

public class SumPair {
    public static boolean isSumPair(int[] arr, int sum) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(hashSet.contains(sum - arr[i])) {
                return true;
            } else {
                hashSet.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {3, 2, 8, 15, -8};
        int sum1 = 17;

        int[] arr2 = new int[] {2, 1, 6, 3};
        int sum2 = 6;

        int[] arr3 = new int[] {5, 8, -3, 6};
        int sum3 = 3;

        System.out.println(isSumPair(arr1, sum1));
        System.out.println(isSumPair(arr2, sum2));
        System.out.println(isSumPair(arr3, sum3));
    }
}
