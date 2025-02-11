package GAMAM.Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlapInterval {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] interval : intervals) {
            if (result.isEmpty() || prev[1] < interval[0]) {
                result.add(interval);
                prev = interval;
            } else {
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] mergeOptimized(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int k = 0;

        for (int i = 0; i < intervals.length; i++) {
            if(intervals[k][1] < intervals[i][0]) {
                k++;
                intervals[k] = intervals[i];
            } else {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            }
        }

        return Arrays.copyOfRange(intervals, 0, k+1);
    }

    public static void printArrays(int[][] arr) {
        for(int[] item: arr) {
            System.out.println(Arrays.toString(item));
        }
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        System.out.println("merge");
        printArrays(merge(arr));
        System.out.println("mergeOptimized");
        printArrays(mergeOptimized(arr));
    }
}
