package GoldmanSachs;

public class LongestPalindrome {
    static String result = "";

    public static String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            getPalindrome(s, i, i); // odd
            getPalindrome(s, i, i + 1); // even
        }

        return result;
    }

    public static void getPalindrome(String s, int low, int high) {
        int l = s.length();
        while (low >= 0 && high < l && s.charAt(low) == s.charAt(high)) {
            if (high - low + 1 > result.length()) {
                result = s.substring(low, high + 1);
            }
            low--;
            high++;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
