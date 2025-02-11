package Oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > temp.get(temp.size()-1)) {
                temp.add(nums[i]);
            } else {
                int idx = Collections.binarySearch(temp, nums[i]); // -(left + 1)
                if(idx < 0) idx = -idx - 1; // Get insertion point
                temp.set(idx, nums[i]);
            }
        }
        return temp.size();
    }
}
