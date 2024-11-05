package GFG.DP.Neetcode;

// https://leetcode.com/problems/decode-ways/
public class numDecode {
    static public int numDecodings(String s) {
        int twoBack = 1; // empty string
        int oneBack = s.charAt(0) == '0' ? 0 : 1;
        int current = oneBack;
        for (int i = 1; i < s.length(); i++) {
            current = 0;
            if (s.charAt(i) != '0') {
                current += oneBack;
            }
            if (
                    s.charAt(i - 1) == '1' ||
                            (s.charAt(i - 1) == '2' && s.charAt(i) < '7')
            ) {
                current += twoBack;
            }
            twoBack = oneBack;
            oneBack = current;

            System.out.println("current - " + current);
        }
        return current;
    }

    static public int numDecodingsDP(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < n + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i-1];
            }
            if (
                    s.charAt(i - 2) == '1' ||
                            (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')
            ) {
                dp[i] += dp[i-2];
            }

            System.out.println("current - " + dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
//        System.out.println(numDecodings("1234"));
        System.out.println(numDecodingsDP("1234"));
    }
}
