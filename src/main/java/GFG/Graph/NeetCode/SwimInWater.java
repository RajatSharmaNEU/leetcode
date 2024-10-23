package GFG.Graph.NeetCode;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInWater {
    public static int getTimeToReach(int[][] grid) {
        // Dijkstra
        // Step 1 - Use minHeap - <dist, row, col>
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Step 2 - Traverse minHeap - BFS
        pq.add(new int[]{grid[0][0], 0, 0});

        int[][] steps = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };

        int minSteps = 0;
        while (!pq.isEmpty()) {
            int[] currCell = pq.poll();
            int val = currCell[0], currRow = currCell[1], currCol = currCell[2];
            if(!visited[currRow][currCol]) {
                visited[currRow][currCol] = true;

                if (currRow == grid.length - 1 && currCol == grid[0].length - 1) {
                    return Math.max(val, minSteps);
                }

                for (int[] step : steps) {
                    int nextRow = currRow + step[0];
                    int nextCol = currCol + step[1];
                    if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && !visited[nextRow][nextCol]) {
                        int nextValue = Math.max(val, grid[nextRow][nextCol]);
                        pq.add(new int[]{nextValue, nextRow, nextCol});
                    }
                }
            }
        }

        return minSteps;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 3},
                {2, 4, 1},
                {1, 2, 1}
        };

        int[][] grid2 = new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };

        System.out.println(getTimeToReach(grid));
        System.out.println(getTimeToReach(grid2));
    }
}
