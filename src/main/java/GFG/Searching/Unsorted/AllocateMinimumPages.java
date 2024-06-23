package GFG.Searching.Unsorted;

import java.util.Arrays;

public class AllocateMinimumPages {
    // Naive - Check for all possible combination and find Min Possible value
    public static int allocateMinPagesNaive(int[] arr, int n, int k) {
        if (k == 1) {
            return sum(arr, 0, n);
        }
        if (n == 1) {
            return arr[0];
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int maxSum = Math.max(
                    allocateMinPagesNaive(arr, i, k - 1),
                    sum(arr, i, n)
            );
//            System.out.println("maxSum - " + maxSum);
            result = Math.min(result, maxSum);
        }

        return result;
    }

    public static int sum(int[] arr, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res = res + arr[i];
        }
        return res;
    }

    // Efficient -
    public static int allocateMinPages(int[] arr, int k) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(isFeasible(arr, mid, k)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // check how many person need if checkSum is max page allowed.
    // if countK <= k ? true : false;
    public static boolean isFeasible(int[] arr, int checkSum, int k) {
        int currSum = 0;
        int countK = 1;
        for (int i = 0; i < arr.length; i++) {
            if(currSum + arr[i] > checkSum) {
                countK++;
                currSum = arr[i];
            } else {
                currSum = currSum + arr[i];
            }
        }

        return countK <= k;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 30, 40};
        int[] arr2 = new int[]{10, 20, 30};
        int[] arr3 = new int[]{10, 5, 30, 1, 2, 5, 10, 10};

        System.out.println(allocateMinPagesNaive(arr1, arr1.length, 2));
        System.out.println(allocateMinPagesNaive(arr2, arr2.length, 1));
        System.out.println(allocateMinPagesNaive(arr3, arr3.length, 3));

        System.out.println(allocateMinPages(arr1, 2));
        System.out.println(allocateMinPages(arr2, 1));
        System.out.println(allocateMinPages(arr3, 3));
    }
}
