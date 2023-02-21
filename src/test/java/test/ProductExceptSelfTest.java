package test;

import org.junit.Test;
import solution.ProductExceptSelf;
import static org.junit.Assert.assertEquals;

public class ProductExceptSelfTest {
    @Test
    public void getProductTest0() {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int[] result = ProductExceptSelf.getProduct(nums);

        assertEquals(360, result[0]);
        assertEquals(2520, result[1]);
        assertEquals(504, result[2]);
        assertEquals(840, result[3]);
        assertEquals(420, result[4]);
        assertEquals(630, result[5]);
    }
}
