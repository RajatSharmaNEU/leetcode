package GFG.String;

import java.util.HashMap;

public class Anagram {
    // Without using string method
    private boolean isAnagramBest(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            int index = s2.indexOf(s1.charAt(i));
            if (index == -1) {
                return false;
            }
            s2 = s2.substring(0, index) + s2.substring(index + 1);
        }

        return s2.length() == 0;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
//
        String s3 = "aaacb";
        String s4 = "cabaa";

        String s5 = "aab";
        String s6 = "bab";

        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram(s1, s2));
        System.out.println(anagram.isAnagramBest(s1, s2));

        System.out.println(anagram.isAnagram(s3, s4));
        System.out.println(anagram.isAnagramBest(s3, s4));

        System.out.println(anagram.isAnagram(s5, s6));
        System.out.println(anagram.isAnagramBest(s5, s6));
    }
}
