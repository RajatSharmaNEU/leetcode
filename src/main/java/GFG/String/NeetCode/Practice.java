package GFG.String.NeetCode;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(map.containsKey(c)) {
                l = map.get(c) + 1;
            }

            map.put(c, r);
            res = Math.max(res, (r - l + 1));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcbb"));
    }
}
