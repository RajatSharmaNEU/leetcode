package GFG.Graph.NeetCode;

import java.util.Arrays;

/*

You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.


 */
public class WallGate {
    static int INF = Integer.MAX_VALUE;

    public void getDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    DFS(r, c, grid[r][c], grid);
                }
            }
        }
    }

    public void DFS(int row, int col, int prev, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == -1) {
            return;
        }

        if(grid[row][col] > 0 && grid[row][col] <= 1 + prev) {
            return;
        }

        grid[row][col] = grid[row][col] == INF ? 1 + prev: Math.min(grid[row][col], 1 + prev);

        DFS(row + 1, col, grid[row][col], grid);
        DFS(row, col + 1, grid[row][col], grid);
        DFS(row - 1, col, grid[row][col], grid);
        DFS(row, col - 1, grid[row][col], grid);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        WallGate wallGate = new WallGate();
        wallGate.getDistance(grid);

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
