package test;

import org.junit.Test;
import solution.Duplicate;

import static org.junit.Assert.assertEquals;

public class DuplicateTest {
    @Test
    public void containsDuplicateTest0() {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        boolean result = Duplicate.containsDuplicate(nums);
        assertEquals(false, result);
    }

    @Test
    public void containsDuplicateTest1() {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4, 7};
        boolean result = Duplicate.containsDuplicate(nums);
        assertEquals(true, result);
    }
}
