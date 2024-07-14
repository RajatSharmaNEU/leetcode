package GFG.Sorting;

public class Union {
    public static void printUnion(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0;
        int j = 0;

        int prev = Integer.MIN_VALUE;

        while (i < n1 && j < n2) {
            if (arr1[i] == prev) {
                i++;
            } else if (arr2[j] == prev) {
                j++;
            } else if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i]);
                prev = arr1[i];
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i]);
                i++;
            } else {
                System.out.println(arr2[j]);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 5, 10, 10, 10, 15, 15, 20};
        int[] arr2 = new int[]{5, 10, 10, 15, 30};

        printUnion(arr1, arr2);
    }
}
