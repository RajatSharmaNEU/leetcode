package GFG.Hashing;

// Find the longest sub array with equal 1 and 0;
public class LongestEqualZeroOneSubBinaryArray {
    public static int longestSubArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        return LongestSumSubArray.findLongestSumSubArray(arr, 0);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 0, 1, 1, 1, 0, 0};
        int[] arr2 = new int[]{1, 1, 1, 1};
        int[] arr3 = new int[]{0, 0, 1, 1, 1, 1, 1, 0, 0};
        int[] arr4 = new int[]{1, 0, 1, 1, 1, 0, 0};

        System.out.println(longestSubArray(arr1));
        System.out.println(longestSubArray(arr2));
        System.out.println(longestSubArray(arr3));
        System.out.println(longestSubArray(arr4));
    }
}
