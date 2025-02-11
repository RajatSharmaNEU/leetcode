package Oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (intervalA, intervalB) -> intervalA[0] - intervalB[0]);

            List<int[]> mergedIntervals = new ArrayList<>();

            for(int[] interval: intervals) {
                if(mergedIntervals.size() == 0) {
                    mergedIntervals.add(interval);
                    continue;
                }

                int[] last = mergedIntervals.get(mergedIntervals.size() - 1);

                if(last[1] >= interval[0]) {
                    last[1] = Math.max(last[1], interval[1]);
                } else {
                    mergedIntervals.add(interval);
                }
            }

            return mergedIntervals.toArray(new int[0][]);
        }
    }
}
