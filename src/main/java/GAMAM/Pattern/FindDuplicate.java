package GAMAM.Pattern;

// https://leetcode.com/problems/find-the-duplicate-number/submissions/
// With using constant space - No Map/Set or No O(n) space Array
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number: " + findDuplicate(nums)); // Output: 2
    }
}
