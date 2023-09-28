package problems.binarySearch.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/set-matrix-zeroes/
public class setZeroes {

    public static void Solution(int[][] matrix) {
//        List<int[][]> zeroElementCoordinates = new ArrayList<>();
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                if (matrix[row][col] == 0) {
//                    zeroElementCoordinates.add(new int[][]{{row, col}});
//                }
//            }
//        }
//
//        for (int[][] zeroElementCoordinate : zeroElementCoordinates) {
//            int zeroElementRow = zeroElementCoordinate[0][0];
//            int zeroElementCol = zeroElementCoordinate[0][1];
//
//            for (int row = 0; row < matrix.length; row++) {
//                for (int col = 0; col < matrix[row].length; col++) {
//                    if (row == zeroElementRow || col == zeroElementCol) {
//                        matrix[row][col] = 0;
//                    }
//                }
//            }
//        }

        int[] zeroRows = new int[matrix.length];
        int[] zeroCols = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows[row] = -1;
                    zeroCols[col] = -1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (zeroRows[row] == -1 || zeroCols[col] == -1 ) {
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
