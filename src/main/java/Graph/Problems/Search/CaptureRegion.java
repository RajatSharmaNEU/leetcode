package Graph.Problems.Search;

import java.util.ArrayList;

public class CaptureRegion {
    public static void markBorder(int r, int c, char[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || A[r][c] != 'O') {
            return;
        }

        A[r][c] = 'B';

        markBorder(r - 1, c, A);
        markBorder(r + 1, c, A);
        markBorder(r, c - 1, A);
        markBorder(r, c + 1, A);
    }

    public static void Solution(char[][] A) {
        ArrayList<ArrayList<Character>> A1 = new ArrayList<ArrayList<Character>>();

        int rows = A.length;
        int cols = A[0].length;

        for (int r = 0; r < rows; r++) {
            markBorder(r, 0, A);
            markBorder(r, cols - 1, A);
        }

        for (int c = 0; c < cols; c++) {
            markBorder(0, c, A);
            markBorder(rows - 1, c, A);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(A[r][c] == 'O') {
                    A[r][c] = 'X';
                } else if (A[r][c] == 'B') {
                    A[r][c] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] A = {
                {'X', 'X', 'X', 'X' },
                {'X', 'O', 'O', 'X' },
                {'X', 'X', 'O', 'X' },
                {'X', 'O', 'X', 'X' }
        };

        Solution(A);

    }
}
