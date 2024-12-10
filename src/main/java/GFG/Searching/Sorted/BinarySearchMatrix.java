package GFG.Searching.Sorted;

public class BinarySearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = rows * cols - 1;

        while(low <= high) {
            int mid = low + ((high - low)/2);

            int row = mid / cols, col = mid % cols;

            if(matrix[row][col] == target) {
                return true;
            }

            if(matrix[row][col] > target) {
                high--;
            } else {
                low++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr, 16));
        System.out.println(searchMatrix(arr, 17));
    }
}
