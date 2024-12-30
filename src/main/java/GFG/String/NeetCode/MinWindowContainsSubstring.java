package GFG.String.NeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowContainsSubstring {
    public static String minWindow(String s, String t) {
        // Sliding Window Problem

        // Map of T - Char and Count - Need
        // Map of Window - Char and Count - Have
        // for loop r -> if Char and Count Matches - Have++
        // While (Have == Need) Loop - remove Left and if leftChar is also in T then Have--
        if (t.isEmpty())
            return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int resLeft = 0, resRight = 0;
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    resLeft = l;
                    resRight = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
