package GFG.String.NeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (hashMap.containsKey(c)) {
                start = Math.max(start, hashMap.get(c) + 1);
            }

            hashMap.put(c, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
