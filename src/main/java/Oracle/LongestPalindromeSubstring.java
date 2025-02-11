package Oracle;

public class LongestPalindromeSubstring {
    String result = "";

    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            palindromeLength(s, i, i + 1);
            palindromeLength(s, i, i);
        }

        return result;
    }

    public void palindromeLength(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(right - left + 1 > result.length()) {
                result = s.substring(left, right+1);
            }
            left--;
            right++;
        }
    }
}
