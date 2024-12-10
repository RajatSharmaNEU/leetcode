package GFG.Searching.Sorted;

public class BinarySearchRotatedArray {
    public static int search(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                return mid;
            }

            if (arr[low] < arr[mid]) { // left part is sorted
                if(k == arr[low]){
                    return low;
                }

                if (k > arr[low] && k < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right part is sorted
                if(k == arr[high]) {
                    return high;
                }

                if(k > arr[mid] && k < arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 30, 40, 50, 8, 9};
        int[] arr2 = new int[]{100, 50, 10, 20, 30, 40, 50};
        System.out.println(search(arr1, 30));
        System.out.println(search(arr2, 40));
    }
}
