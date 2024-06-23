package GFG.Searching.Unsorted;

public class FindPeakElement {
    public static int searchNaive(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        if (arr[0] > arr[1]) {
            return arr[0];
        }

        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }

        return 0;
    }


    public static int search(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {

            mid = (low + high) / 2;

            // first case if mid is the answer
            // if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))

            if ((mid == 0 && arr[mid + 1] <= arr[mid]) ||
                (mid == arr.length - 1 && arr[mid - 1] <= arr[mid])||
                (arr[mid + 1] <= arr[mid] && arr[mid - 1] <= arr[mid])
            ) {
                break;
            }

            // move the right pointer
            if (mid > 0 && arr[mid - 1] > arr[mid])
                high = mid - 1;
            // move the left pointer
            else
                low = mid + 1;
        }

        return arr[mid];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 10, 20, 15, 7};
        int[] arr2 = new int[]{10, 20, 15, 5, 23, 90, 60};
        int[] arr3 = new int[]{80, 70, 60};

        System.out.println(searchNaive(arr1));
        System.out.println(searchNaive(arr2));
        System.out.println(searchNaive(arr3));

        System.out.println(search(arr1));
        System.out.println(search(arr2));
        System.out.println(search(arr3));
    }
}
