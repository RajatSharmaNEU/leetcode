package GFG.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorSort {
    static class SortEvenOdd implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 % 2 - o2 % 2;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("-- Using SortEvenOdd class --");
        Arrays.sort(arr, new SortEvenOdd());
        System.out.println(Arrays.toString(arr));

        System.out.println("-- Using Comparator Reverse Order --");

        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
