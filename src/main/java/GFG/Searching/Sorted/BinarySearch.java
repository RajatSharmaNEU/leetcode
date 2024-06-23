package GFG.Searching.Sorted;

public class BinarySearch {
    public static int binarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 30, 40, 50, 60};
        int[] arr2 = new int[]{5, 15, 25};
        int[] arr3 = new int[]{5, 10, 15, 25, 30};

        System.out.println(binarySearch(arr1, 20));
        System.out.println(binarySearch(arr2, 25));
        System.out.println(binarySearch(arr3, 20));
    }
}
