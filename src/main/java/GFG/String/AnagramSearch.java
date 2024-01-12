package GFG.String;

import java.util.Arrays;

public class AnagramSearch {
    private boolean isAnagram(String s1, String s2) {
        int[] charCount = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)]++;
            charCount[s2.charAt(i)]--;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // O((n - m + 1) x (m))
    private boolean isAnagramStringPresentNaive(String text, String pat) {
        for (int i = 0; i < text.length() - pat.length(); i++) {
            if (text.charAt(i) == pat.charAt(0)) {
                if (isAnagram(text.substring(i, i + pat.length()), pat) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean areSame(int[] textChars, int[] patChars) {
        for (int j = 0; j < 256; j++) {
            if(patChars[j] != textChars[j]) {
                return false;
            }
        }
        return true;
    }

    // Time Complexity - O(n) X 256
    // Space Complexity - O(256)
    private boolean isAnagramPresent(String text, String pat) {
        int[] patChars = new int[256];
        int[] textChars = new int[256];

        // O(m)
        for (int i = 0; i < pat.length(); i++) {
            patChars[pat.charAt(i)]++;
            textChars[text.charAt(i)]++;
        }

        // O(n-m)
        for (int i = pat.length(); i <= text.length(); i++) {
            // O(256)
            if(areSame(textChars, patChars)) {
                return true;
            }
            textChars[text.charAt(i)]++;
            textChars[text.charAt(i - pat.length())]--;
        }

        return false;
    }

    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pat = "frog";
        AnagramSearch anagramSearch = new AnagramSearch();
//        System.out.println(anagramSearch.isAnagramStringPresentNaive(text, pat));
        System.out.println(anagramSearch.isAnagramPresent(text, pat));
    }
}
