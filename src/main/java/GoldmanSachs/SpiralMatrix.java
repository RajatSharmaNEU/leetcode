package GoldmanSachs;

import java.util.Arrays;

public class SpiralMatrix {
    public static int[][] getSpiralMatrix(int n) {
        int left = 0, top = 0;
        int right = n - 1, bottom = n - 1;
        int value = 1;
        int[][] matrix = new int[n][n];

        while (value <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }

            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }

            right--;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = value++;
            }

            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = value++;
            }

            left++;

        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = getSpiralMatrix(4);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
