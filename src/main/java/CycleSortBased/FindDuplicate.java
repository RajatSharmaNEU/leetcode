package CycleSortBased;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;

                // If the number is already at its correct position, it's a duplicate
                if (nums[i] == nums[correctIndex]) {
                    return nums[i];
                }

                // Swap the current number with the one at its correct position
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        return -1; // Shouldn't reach here in valid input
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number: " + findDuplicate(nums)); // Output: 3
    }
}
