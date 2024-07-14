package GFG.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class MergeOverlapInterval {
    public static void mergeOverlap(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int res = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= arr[res][1]) {
                arr[res][0] = Math.min(arr[i][0], arr[res][0]);
                arr[res][1] = Math.max(arr[i][1], arr[res][1]);
            } else {
                res++;
                arr[res] = arr[i];
            }
        }

        for (int i = 0; i <= res; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        // O(n^2)
//        for (int i = 0; i < arr.length; i++) {
//            int low = arr[i][0];
//            int high = arr[i][1];
//
//            for (int j = i + 1; j < arr.length; j++) {
//                if(arr[j][0] > low && arr[j][0] <= high) {
//                    high = Math.max(arr[j][1], arr[i][1]);
//                    i = j;
//                }
//            }
//
//            System.out.println(low + " - " + high);
//        }

    }

    public static void main(String[] args) {
//        int[][] arr1 = new int[][]{{1, 3}, {2, 4}, {5, 7}, {6, 8}};
        int[][] arr2 = new int[][]{{7, 9}, {6, 10}, {4, 5}, {1, 3}, {2, 4}};
//        mergeOverlap(arr1);
        mergeOverlap(arr2);
    }
}
