package GFG.Searching.Sorted;

public class FirstOccurrence {
    public static int binarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k) {
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 10, 10, 10, 20, 20, 40};
        int[] arr2 = new int[]{10, 20, 30};
        int[] arr3 = new int[]{15, 15, 15};
        System.out.println(binarySearch(arr1, 20));
        System.out.println(binarySearch(arr2, 15));
        System.out.println(binarySearch(arr3, 15));
    }
}
