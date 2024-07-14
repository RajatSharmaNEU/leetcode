package GFG.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Input should be uniformly distributed else it would be worst case for sorting
public class BucketSort {
    public static void bucketSort(int[] arr, int k) {
        // Step 1 - Find max element to find divisor
        int max = Arrays.stream(arr).max().getAsInt() + 1;

        // Step 2 - Create bucket
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bucket.add(new ArrayList<>());
        }

        // Step 3 - Add elements in bucket
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (k * arr[i]) / max;
            bucket.get(bucketIndex).add(arr[i]);
        }

        // Step 4 - Sort elements in each bucket
        for (int i = 0; i < k; i++) {
            Collections.sort(bucket.get(i));
        }

        // Step 5 - Collect sorted bucket elements
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                arr[index++] = bucket.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {30, 40, 10, 80, 5, 12, 70};
        System.out.println(Arrays.toString(arr1));
        bucketSort(arr1, 4);
        System.out.println(Arrays.toString(arr1));
    }
}
