package Oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int currDiff = Math.abs(arr[i] - arr[i-1]);

            if(currDiff < minDiff) {
                result = new ArrayList<>();
                minDiff = currDiff;
            }

            if (currDiff == minDiff) {
                List<Integer> currList = new ArrayList<>();
                currList.add(arr[i-1]);
                currList.add(arr[i]);
                result.add(currList);
            }
        }

        return result;
    }
}
