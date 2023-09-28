package neetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    private void DFS(int row, int col, int prevHeight, int[][] heights, boolean[][] canReach) {
        int rows = heights.length;
        int cols = heights[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || heights[row][col] < prevHeight || canReach[row][col]) {
            return;
        }

        canReach[row][col] = true;

        DFS(row - 1, col, heights[row][col], heights, canReach);
        DFS(row + 1, col, heights[row][col], heights, canReach);
        DFS(row, col - 1, heights[row][col], heights, canReach);
        DFS(row, col + 1, heights[row][col], heights, canReach);
    }

    private List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            DFS(r, 0, heights[r][0], heights, canReachPacific);
            DFS(r, cols - 1, heights[r][cols - 1], heights, canReachAtlantic);
        }

        for (int c = 0; c < cols; c++) {
            DFS(0, c, heights[0][c], heights, canReachPacific);
            DFS(rows - 1, c, heights[rows - 1][c], heights, canReachAtlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (canReachPacific[r][c] && canReachAtlantic[r][c]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(r);
                    curr.add(c);
                    result.add(curr);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlantic obj = new PacificAtlantic();
        List<List<Integer>> result = obj.pacificAtlantic(heights);
        for (List<Integer> curr : result) {
            System.out.println(heights[curr.get(0)][curr.get(1)]);
        }
    }
}
