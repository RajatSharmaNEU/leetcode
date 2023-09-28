package Graph.Problems.Search;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    public static void DFS(int r, int c, int prevValue, int[][] heights, boolean[][] canReach) {
        int rows = heights.length;
        int cols = heights[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || canReach[r][c] || heights[r][c] < prevValue) {
            return;
        }

        canReach[r][c] = true;

        DFS(r + 1, c, heights[r][c], heights, canReach);
        DFS(r - 1, c, heights[r][c], heights, canReach);
        DFS(r, c + 1, heights[r][c], heights, canReach);
        DFS(r, c - 1, heights[r][c], heights, canReach);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        // Break condition
        if (heights == null || rows == 0 || cols == 0) {
            return result;
        }

        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            DFS(0, c, heights[0][c], heights, canReachPacific);
            DFS(rows - 1, c, heights[rows - 1][c], heights, canReachAtlantic);
        }

        for (int r = 0; r < rows; r++) {
            DFS(r, 0, heights[r][0], heights, canReachPacific);
            DFS(r, cols - 1, heights[r][cols - 1], heights, canReachAtlantic);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (canReachPacific[r][c] && canReachAtlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result = pacificAtlantic(heights);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(heights[result.get(i).get(0)][result.get(i).get(1)]);
        }
    }
}
