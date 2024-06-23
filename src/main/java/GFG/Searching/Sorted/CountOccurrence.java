package GFG.Searching.Sorted;

public class CountOccurrence {
    public static int find(int[] arr, int k) {
        int firstIndex = FirstOccurrence.binarySearch(arr, k);

        if (firstIndex == -1) {
            return 0;
        }

        return LastOccurrence.binarySearch(arr, k) - firstIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 10, 10, 10, 20, 20, 40};
        int[] arr2 = new int[]{10, 20, 30};
        int[] arr3 = new int[]{15, 15, 15};
        System.out.println(find(arr1, 20));
        System.out.println(find(arr2, 15));
        System.out.println(find(arr3, 15));
    }
}
