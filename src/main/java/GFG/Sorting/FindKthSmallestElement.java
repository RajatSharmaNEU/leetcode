package GFG.Sorting;

public class FindKthSmallestElement {
    public static int findSmallest(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int p = Partition.lomuto(arr, low, high);

            if (p == k - 1) {
                return arr[p];
            } else if (p > k - 1) {
                high = p - 1;
            } else {
                low = p + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 5, 8, 11, 6, 26};
        System.out.println(findSmallest(arr, 2));
    }
}
