package GFG.Hashing;

import java.util.HashMap;
import java.util.Map;

// find elements whose occurrences is more than n/k
public class CountOccurrence {

    public static int findNaive(int[] arr, int k) {
        int m = Math.abs(arr.length / k);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int count = 0;
        for(Map.Entry mapEntry: map.entrySet()) {
            if((int)mapEntry.getValue() > m) {
                count++;
            }
        }

        return count;
    }

    public static int mooreFind(int[] arr, int k) {
        // There can not be more than k-1 elements whose occurrence is greater than n/k
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int n = arr.length;
        int m = Math.abs(n/k);

        for (int i = 0; i < n; i++) {
            if(hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else if(hashMap.size() < k-1) {
                hashMap.put(arr[i], 1);
            } else {
                for(Map.Entry entry : hashMap.entrySet()) {
                    if((int)entry.getValue() == 1) {
                        hashMap.remove(entry.getKey());
                    } else {
                        hashMap.put((int)entry.getKey(), (int)entry.getValue() - 1);
                    }
                }
            }
        }

        // hashmap has potential elements whose occurrence is more than n/k.

        HashMap<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(hashMap.containsKey(arr[i])) {
                result.put(arr[i], result.getOrDefault(arr[i], 0) + 1);
            }
        }

        int count = 0;

        for(Map.Entry entry :  result.entrySet()) {
            if((int)entry.getValue() > m) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{30, 30, 20, 20, 10, 10, 40, 20, 30, 30};
        int[] arr2 = new int[]{10, 10, 20, 30, 20, 10, 10};

        System.out.println(findNaive(arr1, 4));
        System.out.println(findNaive(arr2, 2));

        System.out.println(mooreFind(arr1, 4));
        System.out.println(mooreFind(arr2, 2));
    }
}
