package GFG.DP.LIS;

import java.util.Arrays;

public class LongestDecreasingSubsequence {
    // Optimized
    int ceilIndex(int[] arr, int l, int r, int x) {
        while (r > l) {
            int m = l + (r - l) / 2;
            if (arr[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    // O(nlogn) - LIS
    // here we try to maintain order of sequence
    // the sequence is not the right but length would be
    private int countLISBinary(int[] arr) {
        int dp[] = new int[arr.length];
        int len = 1;

        dp[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > dp[len - 1]) {
                dp[len] = arr[i];
                len++;
            } else {
                int ceil = ceilIndex(dp, 0, len - 1, arr[i]);
                dp[ceil] = arr[i];
            }
        }

        return len;
    }

    // O(n^2) - LIS
    private int countLISNaive(int[] arr) {
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        int result = Arrays.stream(dp).max().orElse(-1);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 8, 2, 4, 3};


        LongestDecreasingSubsequence lis = new LongestDecreasingSubsequence();
        System.out.println(lis.countLISNaive(arr));
//        System.out.println(lis.countLISBinary(arr));
    }
}
