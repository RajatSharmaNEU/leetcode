package test;

import org.junit.Test;
import solution.BuySellStock;

import static org.junit.Assert.assertEquals;

public class BuySellStockTest {
    @Test
    public void maxProfitTest0() {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int result = BuySellStock.maxProfit(nums);
        assertEquals(5, result);
    }

    @Test
    public void maxProfitTest1() {
        int[] nums = new int[]{7, 6, 4, 3, 1};
        int result = BuySellStock.maxProfit(nums);
        assertEquals(0, result);
    }

    @Test
    public void maxProfitTest2() {
        int[] nums = new int[]{7, 2, 3, 1, 6, 4};
        int result = BuySellStock.maxProfit(nums);
        assertEquals(5, result);
    }

    @Test
    public void maxProfitTest3() {
        int[] nums = new int[]{2, 1, 2, 1, 0, 1, 2};
        int result = BuySellStock.maxProfit(nums);
        assertEquals(2, result);
    }

    @Test
    public void maxProfitTest4() {
        int[] nums = new int[]{2,1,3,1,0,1,4};
        int result = BuySellStock.maxProfit(nums);
        assertEquals(4, result);
    }
}
