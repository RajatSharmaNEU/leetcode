package GFG.Graph.Practice;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/description/
// Steps 1 - run dfs row and col wise
// Step 2 - Write DFS to further expand the dfs search
// Step 3 - Accumulate reachAble Pacific and Atlantic cells and return
public class PacificAtlantic {
    private void dfs(int r, int c, int prevHeight, int[][] heights, boolean[][] canReach) {
        int rows = heights.length;
        int cols = heights[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols ||
                canReach[r][c] ||
                heights[r][c] < prevHeight
        ) {
            return;
        }

        canReach[r][c] = true;

        dfs(r - 1, c, heights[r][c], heights, canReach);
        dfs(r + 1, c, heights[r][c], heights, canReach);
        dfs(r, c - 1, heights[r][c], heights, canReach);
        dfs(r, c + 1, heights[r][c], heights, canReach);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();
        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, heights[r][0], heights, canReachPacific);
            dfs(r, cols - 1, heights[r][cols - 1], heights, canReachAtlantic);
        }

        for (int c = 0; c < cols; c++) {
            dfs(0, c, heights[0][c], heights, canReachPacific);
            dfs(rows - 1, c, heights[rows - 1][c], heights, canReachPacific);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(canReachPacific[r][c] && canReachAtlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
            }
        }

        return result;
    }
}
