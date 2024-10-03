package GFG.Backtracking;

import java.util.Arrays;

public class Sudoku {
    public static boolean solveSudoku(int[][] grid) {
        int i = 0, j = 0, N = grid.length;
        // find empty space
        search:
        {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if (grid[i][j] == 0) {
                        break search;
                    }
                }
            }
        }
        System.out.println("Empty cell is (" + i + "," + j + ")");

        // Exit if no empty cell
        if (i == N && j == N) return true;

        // fill value, possible values are 1 to N
        for (int x = 1; x <= N; x++) {
            if (ifSafe(i, j, x, grid)) {
                grid[i][j] = x;
                if (solveSudoku(grid)) return true; // recursive call
            }
        }

        return false;
    }

    public static boolean ifSafe(int i, int j, int x, int[][] grid) {
        // check x value exist or not
        // for example check 2 present in same row or col
        for (int k = 0; k < grid.length; k++) {
            if (grid[k][j] == x || grid[i][k] == x) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 3, 4},
                {0, 0, 2, 1},
                {0, 1, 4, 2},
                {2, 4, 1, 0},
        };
        System.out.println(solveSudoku(grid));

        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
