package GFG.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountDistinctElementWindow {
    public static int findNaive(int[] arr, int k) {
        int result = 0;
        for (int i = 0; i < arr.length - (k - 1); i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                hashSet.add(arr[j]);
            }
            result = Math.max(result, hashSet.size());
        }
        return result;
    }

    public static int find(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int result = map.size();

        for (int i = 1; i <= arr.length - k; i++) {
            if(map.get(arr[i-1]) > 1) {
               map.put(arr[i-1], map.get(arr[i-1]) -1);
            } else {
                map.remove(arr[i-1]);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            result = Math.max(result, map.size());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 20, 10, 30, 40, 10};
        int[] arr2 = new int[]{10, 10, 10, 10};
        int[] arr3 = new int[]{10, 20, 30, 40};

        System.out.println(findNaive(arr1, 4));
        System.out.println(findNaive(arr2, 3));
        System.out.println(findNaive(arr3, 3));
    }
}
