package GFG.String;

import java.util.Arrays;
import java.util.HashMap;

public class LongestDistinctCharacterSubstring {
    private int getLength(String string) {
        int result = 0;
        int[] prev = new int[256];
        Arrays.fill(prev, -1);

        int index = 0;

        for (int i = 0; i < string.length(); i++) {
            index = Math.max(index, prev[string.charAt(i)] + 1);
            int maxEnd = i - index + 1;
            result = Math.max(result, maxEnd);
            prev[string.charAt(i)] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        String string = "abcdabc";
        LongestDistinctCharacterSubstring longestDistinctCharacterSubstring = new LongestDistinctCharacterSubstring();
        System.out.println(longestDistinctCharacterSubstring.getLength(string));
    }
}
