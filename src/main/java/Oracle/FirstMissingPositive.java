package Oracle;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void cycleSort(int[] nums) {
        int index = 0;

        while(index < nums.length) {
            int curr = nums[index];

            if(curr>=0 && curr < nums.length && nums[curr - 1] != curr) {
                int temp = nums[index];
                nums[index] = nums[curr - 1];
                nums[curr - 1] = temp;
            } else {
                index++;
            }
        }
    }

    public static int firstMissingPositive(int[] nums) {
        cycleSort(nums);

        int i = 0;

        while(i < nums.length) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
            i++;
        }

        return nums.length + 1;
    }


    public static void main(String[] args) {
//        int[] nums = new int[] {1, 2, 0};
//        int[] nums = new int[] {7,1, 1, 0, 2};
//        int[] nums = new int[] {1};
        int[] nums = new int[] {2, 1};
//        cycleSort(nums);
//        System.out.println(Arrays.toString(nums));

        System.out.println(firstMissingPositive(nums));

    }
}
