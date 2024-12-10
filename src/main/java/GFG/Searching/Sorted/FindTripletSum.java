package GFG.Searching.Sorted;

import java.util.Arrays;

public class FindTripletSum {
    public static boolean findSumPair(int[] arr, int start, int sum) {
        int low = start+1, high = arr.length - 1;

        while (low < high) {
            int currSum = arr[low] + arr[high];

            if (currSum == sum) {
                return true;
            }

            if (currSum > sum) {
                high--;
            } else {
                low++;
            }
        }

        return false;
    }

    public static boolean findTripletSum(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if(findSumPair(arr, i, k - arr[i])) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 4, 8, 9, 20, 40};

        System.out.println(findTripletSum(arr, 32));
    }
}
