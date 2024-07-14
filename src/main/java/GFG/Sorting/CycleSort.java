package GFG.Sorting;

import java.util.Arrays;

public class CycleSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortCycleDistinct(int[] arr) {
        for (int cs = 0; cs < arr.length; cs++) {
            int item = arr[cs];
            int pos;

            do {
                pos = cs;

                for (int i = cs + 1; i < arr.length; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                }

            } while (pos != cs);
        }
    }

    public static void sortCycle(int[] arr) {
        for (int cs = 0; cs < arr.length; cs++) {
            int item = arr[cs];
            int pos = cs;

            for (int i = cs + 1; i < arr.length; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            // If the element is already in the correct position
            if (pos == cs) {
                continue;
            }

            // Ignore all duplicate elements
            while (item == arr[pos]) {
                pos++;
            }

            if (item != arr[pos]) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
            };

            while (pos != cs) {
                pos = cs;

                for (int i = cs + 1; i < arr.length; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                // Ignore all duplicate elements
                while (item == arr[pos]) {
                    pos++;
                }

                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 40, 50, 10, 30};
        int[] arrDuplicate = new int[]{20, 20, 40, 50, 15, 15, 10, 30};

        System.out.println("Distinct Element Array - " + Arrays.toString(arr));
        sortCycleDistinct(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Duplicate Element Array - " + Arrays.toString(arrDuplicate));
        sortCycle(arrDuplicate);
        System.out.println(Arrays.toString(arrDuplicate));
    }
}
