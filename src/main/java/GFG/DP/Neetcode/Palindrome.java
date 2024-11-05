package GFG.DP.Neetcode;

public class Palindrome {

    public static String longestPalindrome(String s) {
        String str = "";
        int strLen = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {

            // check for odd palindrome
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                System.out.println(s.substring(l, r + 1));
                if(r - l + 1 > strLen) {
                    str = s.substring(l, r + 1);
                    strLen = r - l + 1;
                }

                l--;
                r++;
            }

            // check for even palindrome
            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                System.out.println(s.substring(l, r + 1));
                if(r - l + 1 > strLen) {
                    str = s.substring(l, r + 1);
                    strLen = r - l + 1;
                }

                l--;
                r++;
            }
        }

        return str;
    }

    public static void main(String[] args) {
        String s1 = new String("aaa");
//        String s1 = new String("babad");
//        String s2 = new String("abcd");
//        String s3 = new String("abb");
        System.out.println(longestPalindrome(s1));
//        System.out.println(longestPalindrome(s2));
//        System.out.println(longestPalindrome(s3));
    }
}
