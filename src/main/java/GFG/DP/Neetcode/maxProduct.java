package GFG.DP.Neetcode;

public class maxProduct {
    static int findMaxProd(int[] nums) {
        if (nums.length == 1) return nums[0];

        int res = nums[0];
        int max = 1;
        int min = 1;

        for (int n : nums) {
            int tmp = max * n;
            max = Math.max(n, Math.max(tmp, min * n));
            min = Math.min(n, Math.min(tmp, min * n));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 3, 4};
        int[] arr2 = new int[] {-2, -3, -4};
        int[] arr3 = new int[] {2, -3, 2, 4};
        int[] arr4 = new int[] {2, 3, 2, 4};

        System.out.println(findMaxProd(arr1));
        System.out.println(findMaxProd(arr2));
        System.out.println(findMaxProd(arr3));
        System.out.println(findMaxProd(arr4));
    }
}
