package GFG.DP.LIS;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/
public class LongestChain {
    private int findLongestChain(int[][] chain) {
        // 1. Sort based on first value.
        Arrays.sort(chain, new Comparator<int[]>() {
            @Override
            public int compare(int[] chain1, int[] chain2) {
                return chain1[0] - chain2[0];
            }
        });
        // 2. find dp (longest increasing sequence) based on second value

        int[] dp = new int[chain.length];

        for (int i = 0; i < chain.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < chain.length; j++) {
                //LOGIC - Compare first part with second part of pair
                if (chain[i][0] > chain[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[chain.length - 1];
    }

    public static void main(String[] args) {
        int[][] chain = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
//        int[][] chain = {{5, 24}, {15, 28}, {27, 40}, {39, 60}, {50, 90}};
        LongestChain lc = new LongestChain();
        System.out.println(lc.findLongestChain(chain));
    }
}
