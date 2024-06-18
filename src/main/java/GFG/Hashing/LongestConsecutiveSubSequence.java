package GFG.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubSequence {
    public static int findNaive(int[] arr) {
        Arrays.sort(arr);

        int result = 1;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                count++;
            } else {
                count = 0;
            }

            result = Math.max(result, count);
        }

        return result;
    }

    public static int find(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }

        System.out.println(hashSet);
        int result = 0;

        for (int curr: hashSet) {
            if(!hashSet.contains(curr - 1)) {
                int count = 1;
                while (hashSet.contains(curr + count)){
                    count++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 9, 3, 4, 2, 20};
        int[] arr2 = new int[]{8, 20, 7, 30};
        int[] arr3 = new int[]{20, 30, 40};

        System.out.println(find(arr1));

        System.out.println(findNaive(arr1));
        System.out.println(findNaive(arr2));
        System.out.println(findNaive(arr3));
    }
}
