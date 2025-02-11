package GoldmanSachs;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSubstring {
    public static int lengthOfLongestSubstring(String s) {
        // sliding window technique
        // maintain map ch - count
        // if add right new ch make count 2 - remove left till ch is 1
        // calculate max width

        // pabcwwkew
        // pawbcwkew
        int left = 0, maxWidth = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            Character rightChar = s.charAt(right);

            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            if(map.get(rightChar) > 1) {
                while(map.get(rightChar) != null) {
                    map.remove(s.charAt(left));
                    left++;
                }

                map.put(rightChar, 1);
            }

            maxWidth = Math.max(maxWidth, right - left + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("pabcwwkew"));
    }
}
