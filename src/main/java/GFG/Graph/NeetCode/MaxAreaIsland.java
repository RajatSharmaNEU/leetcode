package GFG.Graph.NeetCode;

// https://leetcode.com/problems/max-area-of-island/description/
public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxIslandSize = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxIslandSize = Math.max(DFS(r, c, grid), maxIslandSize);
                }
            }
        }

        return maxIslandSize;
    }

    public int DFS(int r, int c, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        return 1 + DFS(r + 1, c, grid) + DFS(r, c + 1, grid) + DFS(r - 1, c, grid) + DFS(r, c - 1, grid);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        MaxAreaIsland maxAreaIsland = new MaxAreaIsland();
        System.out.println(maxAreaIsland.maxAreaOfIsland(grid));
    }
}
