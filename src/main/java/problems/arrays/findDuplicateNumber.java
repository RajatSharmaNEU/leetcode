package problems.arrays;

public class findDuplicateNumber {
    public static int Solution(int[] nums) {
        // No need of map as we do need count of element
        // We need to just check the presence of element

        // Map<Integer, Integer> hashMap = new HashMap<>();

        // for (int num : nums) {
        //     if (hashMap.containsKey(num)) {
        //         return num;
        //     } else {
        //         hashMap.put(num, 1);
        //     }
        // }
        // return -1;

        boolean[] map = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(map[nums[i]]) return nums[i];
            map[nums[i]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 4, 2, 2};
        int[] nums2 = new int[]{3, 1, 3, 4, 2};
        System.out.println(Solution(nums1));
        System.out.println(Solution(nums2));
    }
}
