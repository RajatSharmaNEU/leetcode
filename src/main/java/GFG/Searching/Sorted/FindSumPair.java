package GFG.Searching.Sorted;

public class FindSumPair {
    public static boolean findSumPair(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int sum = arr[low] + arr[high];

            if (sum == k) {
                return true;
            }

            if (sum > k) {
                high--;
            } else {
                low++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 8, 9, 11, 12, 20, 30};
        System.out.println(findSumPair(arr, 23));
    }
}
