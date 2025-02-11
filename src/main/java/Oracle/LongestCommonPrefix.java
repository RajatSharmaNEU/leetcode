package Oracle;

import GoldmanSachs.LongestPalindrome;

import java.util.List;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);

                if(result.isEmpty()) {
                    return "";
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs1 = new String[]{"flower","flow","flight"};
        String[] strs2 = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs2));
    }
}
