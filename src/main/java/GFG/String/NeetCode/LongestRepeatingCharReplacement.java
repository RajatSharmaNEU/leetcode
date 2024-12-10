package GFG.String.NeetCode;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {
    public static int characterReplacementUsingHashMap(String s, int k) {
        // Use Array size[26] for more optimization
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int l = 0;
        int res = 0;
        int maxF = 0;

        for(int r = 0; r < s.length(); r++) {
            int windowSize = r - l + 1; // window size
            char curr = s.charAt(r);

            hashMap.put(curr, hashMap.getOrDefault(curr, 0) + 1);

//          maxF = hashMap.values().stream().max((a, b) -> Integer.compare(a, b)).orElse(0);
            maxF = Math.max(maxF, hashMap.get(curr));

            if(windowSize - maxF > k) {
                char leftChar = s.charAt(l);
                hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static int characterReplacementUsingArray(String s, int k) {
        int[] map = new int[26];

        int l = 0, res = 0, maxF = 0;

        for(int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            map[rChar - 'A']++;
            maxF = Math.max(maxF, map[rChar - 'A']);

            if((r - l +1) - maxF > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacementUsingHashMap("AABABBA", 1));
        System.out.println(characterReplacementUsingArray("AABABBA", 1));
    }
}
