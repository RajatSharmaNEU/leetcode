package problems.binarySearch.arrays;

import java.util.ArrayList;
import java.util.List;

public class practiceArray {
    public static void Solution(int[][] matrix) {
        int[] zeroRows = new int[matrix.length];
        int[] zeroColumns = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    zeroRows[row] = -1;
                    zeroColumns[col] = -1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(zeroRows[row] == -1 || zeroColumns[col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        Solution(matrix2);
    }
}
