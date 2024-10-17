package GFG.Graph.NeetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    DFS(r, c, grid);
                    result++;
                }
            }
        }

        return result;
    }

    public void DFS(int row, int col, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row >= rows || col >= cols || row < 0 || col < 0 || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        DFS(row + 1, col, grid);
        DFS(row, col + 1, grid);
        DFS(row - 1, col, grid);
        DFS(row, col - 1, grid);
    }

    public static void main(String[] args) {
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        char[][] grid1 = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        char[][] grid2 = new char[][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'},
        };
        System.out.println(numberOfIsland.numIslands(grid1));
        System.out.println(numberOfIsland.numIslands(grid2));
    }
}
