package GFG.Hashing;

import java.util.HashMap;

public class CountFrequency {
    public static void count(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(hashMap);
    }
    public static void main(String[] args) {
        int[] arr = new int[] {50, 50, 10, 40, 10};
        count(arr);
    }
}
