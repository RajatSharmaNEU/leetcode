package GFG.String;

import java.util.Arrays;

public class LeftMostNonRepeat {

    private int findIndex(String string) {
        boolean[] count = new boolean[256];
        int result = Integer.MAX_VALUE;

        for (int i = string.length()-1; i >= 0 ; i--) {
            if(count[string.charAt(i)] == false) {
                count[string.charAt(i)] = true;
                result = Math.min(result, i);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int leftNonRepeat(String str) {
        int[] cache = new int[26];

        for (int i = 0; i < str.length(); i++) {
            cache[str.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(cache));
        for (int i = 0; i < str.length(); i++) {
            if(cache[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String string = "forgeeksforgeeks";
        LeftMostNonRepeat leftMostNonRepeat = new LeftMostNonRepeat();
        System.out.println(leftMostNonRepeat.findIndex(string));
        System.out.println(leftMostNonRepeat.leftNonRepeat(string));
    }
}
