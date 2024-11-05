package GFG.DP;

public class EggDrop {
    private int minTrialsDP(int f, int e) {
        int[][] dp = new int[f + 1][e + 1];

        // for 0 and 1 floor
        for (int i =1; i <= e; i++) {
            dp[1][i] = 1;
            dp[0][i] = 0;
        }

        // if one egg but f floors
        for (int i = 1; i <= f ; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i <= f; i++) { // floor
            for (int j = 2; j <= e; j++) { // eggs
                dp[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j],  1 + Math.max(dp[x-1][j-1], dp[i-x][j]));
                }
            }
        }

        return dp[f][e];
    }
    private int minTrials(int k, int eggs) {

        if(k == 1 || k == 0 || eggs == 1) {
            return k;
        }

        int minTrail = Integer.MAX_VALUE;

        // let x is the trail k
        for (int x = 1; x <= k; x++) {
            // max of break, not-break
            int currTrail = 1 + Math.max(minTrials(x-1, eggs-1), minTrials(k-x, eggs));
            minTrail = Math.min(minTrail, currTrail);
        }

        return minTrail;
    }

    public static void main(String[] args) {
        EggDrop eggDrop = new EggDrop();
        System.out.println(eggDrop.minTrials(30, 2));
        System.out.println(eggDrop.minTrialsDP(30, 2));
    }
}
