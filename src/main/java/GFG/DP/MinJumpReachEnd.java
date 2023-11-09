package GFG.DP;

public class MinJumpReachEnd {

    private int minJumpRecursive(int[] arr, int endIndex) {
        // From endIndex find the possible candidate
        if (endIndex == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < endIndex; i++) {
            if (i + arr[i] >= endIndex) {
                res = Math.min(res, 1 + minJumpRecursive(arr, i));
            }
        }

        return res;
    }

    private int minJumpDP(int[] arr, int endIndex) {
        int[] dp = new int[endIndex + 1];

        for (int i = 0; i <= endIndex; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i <= endIndex; i++) {
            for (int j = 0; j < i ; j++) {
                if (j + arr[j] >= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[endIndex];
    }

    public static void main(String[] args) {
        MinJumpReachEnd minJumpReachEnd = new MinJumpReachEnd();
        int[] arr = new int[]{3, 4, 2, 1, 2, 1};
        System.out.println(minJumpReachEnd.minJumpRecursive(arr, arr.length - 1));
        System.out.println(minJumpReachEnd.minJumpDP(arr, arr.length - 1));

    }
}
