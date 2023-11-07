package GFG.DP.LIS;

public class MaximumSumIncreasingSequence {
    private int maxSumIS(int arr[]) {
        int i, j, max = 0;
        int n = arr.length;
        int msis[] = new int[n];

        /* Compute maximum sum values in bottom up manner */
        for (i = 0; i < n; i++) {
            msis[i] = arr[i];
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    msis[i] = Math.max(msis[i], msis[j] + arr[i]);
                }
            }
        }

        /* Pick maximum of all msis values */
        for (i = 0; i < n; i++)
            if (max < msis[i])
                max = msis[i];

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 8, 10};


        MaximumSumIncreasingSequence msis = new MaximumSumIncreasingSequence();
        System.out.println(msis.maxSumIS(arr));
    }
}
