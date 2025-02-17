package GoldmanSachs;

public class DecodeWay {
    public static int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            if (curr != '0') {
                dp[i] = dp[i - 1];
            }

            if (prev == '1' || (prev == '2' && curr < '7')) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("102"));
    }
}
