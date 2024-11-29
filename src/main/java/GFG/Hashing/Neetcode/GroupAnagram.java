package GFG.Hashing.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store result
        // Array which convert into string to uniquely act as key

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String str: strs) {
            // char[] charArray = str.toCharArray();
            // Arrays.sort(charArray);
            // String key = Arrays.toString(charArray);

            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(str);
        }

//        System.out.println(hashMap.keySet());
        List<List<String>> result = new ArrayList<>(hashMap.values());
        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[] {"eaat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }
}
