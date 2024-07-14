package GFG.Sorting;

import java.util.Arrays;

// Segregation condition determine the element to swap
public class SegregationTwoTypes {
    public static void hoareSegregationPosNeg(int[] arr) {
        int pivot = 0;
        int i = -1;
        int j = arr.length;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] >= pivot);

            if (i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void hoareSegregationEvenOdd(int[] arr) {
        // pivot could be any condition
        // For Pos Neg - use 0
        // For Object with Fail and Pass value - Use Pass
        // For even and odd - use Remainer
        int pivot = 0;
        int i = -1;
        int j = arr.length;

        while (true) {
            do {
                i++;
            } while (arr[i] % 2 == pivot);

            do {
                j--;
            } while (arr[j] % 2 != pivot);

            if (i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-12, -7, 11, 18, -10, 15};

        System.out.println(Arrays.toString(arr1));
        hoareSegregationPosNeg(arr1);
        System.out.println("Positive Negative Segregation - " + Arrays.toString(arr1));
        hoareSegregationEvenOdd(arr1);
        System.out.println("Even Odd Segregation - " + Arrays.toString(arr1));
    }
}
