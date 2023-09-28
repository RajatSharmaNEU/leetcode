package problems.binarySearch;

public class MissingNumber {
    // O(1) extra space complexity and O(n) runtime complexity
    public static int Solution(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        System.out.println(Solution(nums));
    }
}
