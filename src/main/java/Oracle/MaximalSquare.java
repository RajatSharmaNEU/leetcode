package Oracle;

import GFG.Backtracking.Neetcode.SubSets;

import java.util.Arrays;

public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxsqlen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    int diagonalMin = Math.min(dp[i][j - 1], dp[i - 1][j]);

                    if(i == 1 && j == 2) {
                        System.out.println(dp[i][j - 1]);
                        System.out.println(dp[i - 1][j]);
                        System.out.println(diagonalMin);
                    }
                    dp[i][j] = Math.min(diagonalMin, dp[i - 1][j - 1]) + 1;
                }

                maxsqlen = Math.max(maxsqlen, dp[i][j]);
            }
        }
        for(int[] check:  dp) {
            System.out.println(Arrays.toString(check));
        }
        return maxsqlen * maxsqlen;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalSquare(matrix));
    }

}
