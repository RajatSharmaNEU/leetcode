package GFG.Searching.Sorted;

public class FindMinRotatedArray {
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }


        }

        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(findMin(arr));
    }
}
