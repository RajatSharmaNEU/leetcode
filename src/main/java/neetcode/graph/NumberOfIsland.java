package neetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIsland {
    public void DFS(int row, int col, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(row<0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        DFS(row+1, col, grid);
        DFS(row-1, col, grid);
        DFS(row, col+1, grid);
        DFS(row, col-1, grid);
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    DFS(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid =  new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid1 =  new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIsland obj = new NumberOfIsland();
        System.out.println(obj.numIslands(grid));
        System.out.println(obj.numIslands(grid1));
    }
}
