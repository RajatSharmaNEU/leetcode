package GoldmanSachs;

public class DecodeWay {
    public static int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // length = 1 => 1
        // length = 2 => ? two steps back 1 or 2

        for(int i = 2; i < n + 1; i++) {
            if(s.charAt(i-1) != '0') {
                dp[i] = dp[i] + dp[i-1];
            }

            if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {
                dp[i] = dp[i] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("102"));
    }
}
