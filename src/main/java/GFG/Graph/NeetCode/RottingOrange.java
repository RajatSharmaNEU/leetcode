package GFG.Graph.NeetCode;

public class RottingOrange {
    public int findOrangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] max = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    DFS(r + 1, c, 0, grid, max);
                    DFS(r, c + 1, 0, grid, max);
                    DFS(r - 1, c, 0, grid, max);
                    DFS(r, c - 1, 0, grid, max);
                }
            }
        }

        int maxTime = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (max[r][c] == 0) {
                        return -1;
                    }
                    maxTime = Math.max(maxTime, max[r][c]);
                }
            }
        }

        return maxTime;
    }

    public void DFS(int r, int c, int prev, int[][] grid, int[][] max) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0 || grid[r][c] == 2) {
            return;
        }

        if (max[r][c] != 0 && max[r][c] <= 1 + prev) {
            return;
        }

        if (grid[r][c] == 1) {
            max[r][c] = max[r][c] == 0 ? 1 + prev : Math.min(max[r][c], 1 + prev);
        }

        DFS(r + 1, c, max[r][c], grid, max);
        DFS(r, c + 1, max[r][c], grid, max);
        DFS(r - 1, c, max[r][c], grid, max);
        DFS(r, c - 1, max[r][c], grid, max);
    }

    public static void main(String[] args) {
        int[][] gridA = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] gridB = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        int[][] gridC = new int[][]{
                {0, 2, 2}
        };

        RottingOrange rottingOrange = new RottingOrange();
        System.out.println(rottingOrange.findOrangesRotting(gridA));
        System.out.println(rottingOrange.findOrangesRotting(gridB));
        System.out.println(rottingOrange.findOrangesRotting(gridC));
    }
}
