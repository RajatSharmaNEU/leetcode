package GFG.Greedy.Neetcode;

public class MinSubArraySumCircular {
    public static int minSubarraySumCircular(int[] nums) {
        // Kadane Algo
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        int currMaxSum = 0;
        int currMinSum = 0;

        int totalSum = 0;

        for(int num: nums) {
            // Max sum of Sub Array
            currMaxSum = Math.max(num, currMaxSum + num);
            maxSum = Math.max(currMaxSum, maxSum);

            // Min sum of Sub Array
            currMinSum = Math.min(num, currMinSum + num);
            minSum = Math.min(currMinSum, minSum);

            totalSum = totalSum + num;
        }

        // If all values are negative
        if(minSum == totalSum) {
            return minSum;
        }

        // return max of non-circular and circular
        return Math.min(minSum, totalSum - maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {3,-1,-2, 1};
        System.out.println(minSubarraySumCircular(arr));
    }
}
