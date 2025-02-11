package GFG.Graph;

import java.util.PriorityQueue;

public class PathWithMinimumEfforts {
    // https://leetcode.com/problems/path-with-minimum-effort/

    /*
        Time Complexity: O(rows * cols * log(rows * cols))
        Space Complexity: O(rows * cols)
    */
    public int minimumEffortPath(int[][] heights) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int rows = heights.length;
        int cols = heights[0].length;

        // row, col, effortDiff
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int maxEffort = 0;

        boolean[][] visited = new boolean[rows][cols];
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            int currEffort = curr[2];

            maxEffort = Math.max(maxEffort, currEffort);

            if (currRow == rows - 1 && currCol == cols - 1) {
                return maxEffort;
            }

            if (visited[currRow][currCol]) {
                continue;
            }

            for (int i = 0; i < dir.length; i++) {
                int nextRow = currRow + dir[i][0];
                int nextCol = currCol + dir[i][1];

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol] == true) {
                    continue;
                }

                pq.add(
                        new int[]{nextRow, nextCol, Math.abs(heights[currRow][currCol] - heights[nextRow][nextCol])}
                );
            }

            visited[currRow][currCol] = true;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println(new PathWithMinimumEfforts().minimumEffortPath(heights));
    }
}
