package GFG.DP;

public class Practice {
    private int minJumpRecursive(int[] arr, int endIndex) {
        if (endIndex == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < endIndex; i++) {
            if (i + arr[i] >= endIndex) {
                min = Math.min(min, 1 + minJumpRecursive(arr, i));
            }
        }

        return min;
    }

    private int minJumpDP(int[] arr, int endIndex) {
        int[] dp = new int[arr.length + 1];

        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            if(i + arr[i] >= endIndex) {
                dp[i] = Math.min(dp[i], 1 + dp[i+arr[i] - endIndex]);
            }
        }

        return dp[endIndex];
    }


    public static void main(String[] args) {
        Practice practice = new Practice();
        int[] arr = new int[]{3, 4, 2, 1, 2, 1};
        System.out.println(practice.minJumpRecursive(arr, arr.length - 1));
        System.out.println(practice.minJumpDP(arr, arr.length - 1));
    }
}
