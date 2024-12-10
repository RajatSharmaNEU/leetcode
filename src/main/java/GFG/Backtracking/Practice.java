package GFG.Backtracking;

import java.util.Arrays;

public class Practice {
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void placeNQueen(int N){
        char[][] board = new char[N][N];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], 'X');
        }

        if(solveRecursive(0, N, board)){
            printBoard(board);
        }
    }

    public static boolean solveRecursive(int col, int N, char[][] board) {
        if(col == N) {
            return true;
        }

        for (int r = 0; r < N; r++) {
            if(isSafe(r, col, N, board)) {
                board[r][col] = 'Q';
                if(solveRecursive(col+1, N, board)) {
                    return true;
                }
                board[r][col] = 'X';
            }

        }

        return false;
    }

    public static boolean isSafe(int currentRow, int currentCol, int N, char[][] board) {
        // check if same row has Queen
        for (int i = 0; i < N; i++) {
            if (board[currentRow][i] == 'Q') {
                return false;
            }
        }

        // check if diagonally upper side has Queen
        for (int i = currentRow, j = currentCol; i>=0 && j>=0; i--, j--) {
            if (board[currentRow][i] == 'Q') {
                return false;
            }
        }
        // check if diagonally lower side has Queen
        for (int i = currentRow, j = currentCol; i<N && j>=0; i++, j--) {
            if (board[currentRow][i] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        placeNQueen(4);
    }
}
