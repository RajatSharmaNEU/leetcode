package GFG.DP.LIS;

public class MaximumLengthBionicSequence {
    private int lbs(int[] arr) {
        int n = arr.length;

        /* Allocate memory for LIS[] and initialize LIS values as 1 for all indexes */
        int[] lis = new int[n];

        /* Compute LIS values from left to right */
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }

        /* Allocate memory for lds and initialize LDS values for all indexes */
        int[] lds = new int[n];

        /* Compute LDS values from right to left */
        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j])
                    lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }


        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        // Bionic - Longest increasing + decreasing sequence
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        MaximumLengthBionicSequence mlbs = new MaximumLengthBionicSequence();
        System.out.println(mlbs.lbs(arr));
    }
}
