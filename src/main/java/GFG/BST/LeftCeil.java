package GFG.BST;

import java.util.Arrays;
import java.util.TreeSet;

public class LeftCeil {
    public static int[] getLeftCeilNaive(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int ceil = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if(arr[j] >= arr[i]) {
                    ceil = Math.min(ceil, arr[j]);
                }
            }
            result[i] = ceil == Integer.MAX_VALUE ? -1 : ceil;
        }

        return result;
    }

    public static void getLeftCeil(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(treeSet.ceiling(arr[i]) != null ? treeSet.ceiling(arr[i]) : -1);
            treeSet.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 8, 30, 15, 25, 12};
        int[] arr2 = new int[] {30, 20, 10};
        int[] arr3 = new int[] {10, 20, 30};
        int[] arr4 = new int[] {6, 18, 4, 5};
        System.out.println("---Arr1---");
        Arrays.stream(getLeftCeilNaive(arr1)).forEach(System.out::println);
//        System.out.println("---Arr2---");
//        Arrays.stream(getLeftCeilNaive(arr2)).forEach(System.out::println);
//        System.out.println("---Arr3---");
//        Arrays.stream(getLeftCeilNaive(arr3)).forEach(System.out::println);
//        System.out.println("---Arr4---");
//        Arrays.stream(getLeftCeilNaive(arr4)).forEach(System.out::println);

        getLeftCeil(arr1);
    }
}
