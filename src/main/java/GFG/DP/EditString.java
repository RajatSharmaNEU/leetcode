package GFG.DP;

public class EditString {
    private int editDistanceDP(String X, String Y, int xl, int yl) {
        int[][] dp = new int[xl + 1][yl + 1];

        // Case when one string is empty
        for (int i = 0; i < xl + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < yl + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < xl + 1; i++) {
            for (int j = 1; j < yl + 1; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }

        return dp[xl][yl];
    }

    // Minimum number of operation - Add, Replace, Delete to Match Two Strings
    private int editDistanceRecursive(String X, String Y, int xl, int yl) {
        if (xl == 0) {
            return yl;
        }

        if (yl == 0) {
            return xl;
        }

        if (X.charAt(xl - 1) == Y.charAt(yl - 1)) {
            return editDistanceRecursive(X, Y, xl - 1, yl - 1);
        }

        int replace = editDistanceRecursive(X, Y, xl - 1, yl - 1);
        int remove = editDistanceRecursive(X, Y, xl - 1, yl);
        int add = editDistanceRecursive(X, Y, xl, yl - 1);
        return 1 + Math.min(Math.min(replace, remove), add);
    }

    public static void main(String[] args) {
        String X = "CAT";
        String Y = "CUT";

//        String X = "SATURDAY";
//        String Y = "SUNDAY";

        EditString ed = new EditString();
        System.out.println(ed.editDistanceRecursive(X, Y, X.length(), Y.length()));
        System.out.println(ed.editDistanceDP(X, Y, X.length(), Y.length()));



    }
}
