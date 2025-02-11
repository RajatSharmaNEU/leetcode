package GoldmanSachs;

public class SearchInRotatedArray {

    public static int find(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high) {
            int mid = low + ((high - low) / 2);

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[low] == target) {
                return low;
            }

            if(nums[high] == target) {
                return high;
            }

            // left part is sorted
            if(nums[low] < nums[mid]) {
                if(target > nums[low] && target < nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(target > nums[mid] && target < nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        System.out.println(find(nums, 0));
        System.out.println(find(nums, 9));
        System.out.println(find(nums, 7));
    }
}
