package GFG.Backtracking;

import java.util.Arrays;

public class RatInAMaze {
    static boolean solveMazeStandard(int[][] maze, int i, int j) {
        int rows = maze.length;
        int cols = maze[0].length;

        if (i == rows - 1 && j == cols - 1) { // break condition
            return true;
        }

        if (i < rows && j < cols && maze[i][j] == 1) { // isSafe condition
            if (solveMazeStandard(maze, i + 1, j) == true) return true; // possible steps
            else if (solveMazeStandard(maze, i, j + 1) == true) return true; // possible steps
        }

        return false;
    }

    static boolean solveMazeBackTracking(int[][] maze, int i, int j) {
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] sol = new int[rows][cols];

        if(solveMazeRecursive(maze, sol, i, j)){
            System.out.println("----Possible path----");
            for (int[] row: sol) {
                System.out.println(Arrays.toString(row));
            }
        }

        return solveMazeRecursive(maze, sol, i, j);
    }

    static boolean solveMazeRecursive(int[][] maze, int[][] sol, int i, int j) {
        int rows = maze.length;
        int cols = maze[0].length;

        if (i == rows - 1 && j == cols - 1) { // break condition
            sol[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j)) {
            sol[i][j] = 1;
            if (solveMazeRecursive(maze, sol, i + 1, j) == true) return true; // possible steps
            else if (solveMazeRecursive(maze, sol, i, j + 1) == true) return true; // possible steps

            sol[i][j] = 0;
        }

        return false;
    }

    static boolean isSafe(int[][] maze, int i, int j) {
        int rows = maze.length;
        int cols = maze[0].length;
        return i < rows && j < cols && maze[i][j] == 1;
    }


    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

//        System.out.println("Can Rat reach " + solveMazeStandard(maze, 0, 0));
        System.out.println("Can Rat reach " + solveMazeBackTracking(maze, 0, 0));
    }
}
