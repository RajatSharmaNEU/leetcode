package GFG.Graph.NeetCode;

import java.util.Arrays;

public class SurroundedRegions {
    public static void DFS(int row, int col, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        if (row >= rows || col >= cols || row < 0 || col < 0 || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'T';

        DFS(row + 1, col, board);
        DFS(row, col + 1, board);
        DFS(row - 1, col, board);
        DFS(row, col - 1, board);
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                DFS(r, 0, board);
            }

            if (board[r][cols - 1] == 'O') {
                DFS(r, cols - 1, board);
            }
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                DFS(0, c, board);
            }

            if (board[rows - 1][c] == 'O') {
                DFS(rows - 1, c, board);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    public static void main(String[] args) {
        char[][] boardA = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(boardA);

        for (char[] rows : boardA) {
            System.out.println(Arrays.toString(rows));
        }
    }
}
