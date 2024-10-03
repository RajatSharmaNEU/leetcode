package GFG.Backtracking;

import java.util.Arrays;

public class NQueen {
    public static void printBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] == true ? "Q" : "X");
            }
            System.out.println();
        }
    }
    public static boolean placeNQueen(int N) {
        boolean[][] board = new boolean[N][N];
        if (solveRecursive(0, N, board) == true) {
            printBoard(board);
        }
        return solveRecursive(0, N, board);
    }

    public static boolean solveRecursive(int col, int N, boolean[][] board) {
        if(col == N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col, N, board)) {
                board[i][col] = true;
                if (solveRecursive(col + 1, N, board)) {
                    return true;
                }
                board[i][col] = false;
            }
        }

        return false;
    }

    public static boolean isSafe(int currentRow, int currentCol, int N, boolean[][] board) {
        // check if same row has Queen
        for (int i = 0; i < N; i++) {
            if (board[currentRow][i]) {
                return false;
            }
        }

        // check if diagonally upper side has Queen
        for (int i = currentRow, j = currentCol; i>=0 && j>=0; i--, j--) {
            if(board[i][j]) {
                return false;
            }
        }
        // check if diagonally lower side has Queen
        for (int i = currentRow, j = currentCol; i<N && j>=0; i++, j--) {
            if(board[i][j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        placeNQueen(4);
    }

}
