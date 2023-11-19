package GFG.Stack;

import java.util.Arrays;

public class MaxRectangle {
    private int findMaxRectangleArea(int[][] matrix) {
        HistogramArea histogramArea = new HistogramArea();
        int res = histogramArea.getMaxAreaBest(matrix[0]);

        int row = matrix.length;
        int col = matrix[0].length;

        // here we are considering upper rows 1 to add if current row 1 only
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i-1][j];
                }
            }
            System.out.println(Arrays.toString(matrix[i]));
            res = Math.max(res, histogramArea.getMaxAreaBest(matrix[i]));
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
        };

        MaxRectangle maxRectangle = new MaxRectangle();
        System.out.println(maxRectangle.findMaxRectangleArea(matrix));
    }
}
