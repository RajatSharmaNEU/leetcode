package test;

import org.junit.Test;
import solution.TwoSum;
import static org.junit.Assert.assertEquals;

public class TwoSumTest {
    @Test
    public void getTwoSumTest() {
        int[] nums = new int[] {2,3,4,6};
        int[] result = TwoSum.getTwoSum(nums, 7);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }
}
