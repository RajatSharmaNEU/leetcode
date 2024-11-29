package GFG.Searching.Sorted;

public class UnboundedBinarySearch {

    public static int search(int[] arr, int n) {
        if(arr[0] == n) {
            return 0;
        }

        int i = 1;

        while (arr[i] < n) {
            i = i * 2;
        }

        if(arr[i] == n) {
            return i;
        }

        int low = i/2 + 1;
        int high = i - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 15, 20, 40, 60, 80, 100, 200, 500, 1000};
        System.out.println(search(arr, 20));
    }
}
