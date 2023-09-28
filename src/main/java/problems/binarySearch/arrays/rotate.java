package problems.binarySearch.arrays;

// https://leetcode.com/problems/rotate-image/
public class rotate {
    public static void solution(int[][] matrix) {
        int n = matrix.length - 1;

        System.out.println("Input Matrix");

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j];
                matrix[i][n - j] = temp;
            }
        }

        System.out.println("Intermediate Matrix");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][n - i];
                matrix[n - j][n - i] = temp;
            }
        }

        System.out.println("Output Matrix");

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        solution(matrix1);
        solution(matrix2);

    }
}
