package solution;

public class ProductExceptSelf {
    public static int[] getProduct(int[] nums) {
        int product = 1;
        int i = 0;
        int zeroCount = 0;
        int zeroIndex = -1;
        int[] result = new int[nums.length];

        while (i < nums.length) {
            if (nums[i] != 0) {
                product = product * nums[i];
            } else if (zeroCount == 1) {
                return result;
            } else {
                zeroCount = 1;
                zeroIndex = i;
            }
            i++;
        }

        if (zeroIndex > -1) {
            result[zeroIndex] = product;
            return result;
        }

        int j = 0;
        while (j < nums.length) {
            result[j] = product / nums[j];
            j++;
        }
        return result;
    }
}
