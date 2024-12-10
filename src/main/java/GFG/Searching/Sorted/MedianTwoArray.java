package GFG.Searching.Sorted;

public class MedianTwoArray {
    public static int findMedian(int[] arr1, int[] arr2) {
        // Merge the two arrays
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // Copy remaining elements
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        // Find the median
        int n = merged.length;
        if (n % 2 == 0) {
            // If even, return the average of the two middle elements
            return (merged[n / 2 - 1] + merged[n / 2]) / 2;
        } else {
            // If odd, return the middle element
            return merged[n / 2];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 30, 40, 50};
        int[] arr2 = new int[]{5, 15, 25, 35, 45};

        System.out.println(findMedian(arr1, arr2));
    }
}
