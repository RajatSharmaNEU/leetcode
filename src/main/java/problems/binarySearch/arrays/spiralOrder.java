package problems.binarySearch.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class spiralOrder {
    public static List<Integer> Solution(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int r = 0;
        int c = 0;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int turn = 1;

        while (r <= row && c <= col) {
            if (turn == 1) {
                for (int i = c; i <= col; i++) {
                    ans.add(matrix[r][i]);
                }
                r++;
                turn = 2;
            } else if (turn == 2) {
                for (int i = r; i <= row; i++) {
                    ans.add(matrix[i][col]);
                }
                col--;
                turn = 3;
            } else if (turn == 3) {
                for (int i = col; i >= c; i--) {
                    ans.add(matrix[row][i]);
                }
                row--;
                turn = 4;
            } else if (turn == 4) {
                for (int i = row; i >= r; i--) {
                    ans.add(matrix[i][c]);
                }
                c++;
                turn = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int i : Solution(matrix1)) {
            System.out.print(i + " ");
        }
    }
}
