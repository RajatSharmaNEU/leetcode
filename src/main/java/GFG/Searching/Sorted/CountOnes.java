package GFG.Searching.Sorted;

public class CountOnes {
    public static int binarySearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1 && (mid == 0 || mid != 0 && arr[mid - 1] == 0)) {
                return arr.length - mid;
            } else if(arr[mid] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 0, 0, 1, 1, 1, 1};
        int[] arr2 = new int[]{1, 1, 1, 1, 1};
        int[] arr3 = new int[]{0, 0, 0, 0};
        System.out.println(binarySearch(arr1));
        System.out.println(binarySearch(arr2));
        System.out.println(binarySearch(arr3));
    }
}
