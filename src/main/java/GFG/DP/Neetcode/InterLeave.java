package GFG.DP.Neetcode;

public class InterLeave {
    public static boolean isInterLeaveRecursive(String s1, String s2, String s3) {
        return dfsRecursive(0, 0, 0, s1, s2, s3);
    }

    public static boolean dfsRecursive(int i, int j, int k, String s1, String s2, String s3) {
        if (s3.length() == k) {
            return i == s1.length() && j == s2.length();
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (dfsRecursive(i + 1, j, k + 1, s1, s2, s3)) {
                return true;
            }
        }

        if (j < s1.length() && s2.charAt(j) == s3.charAt(k)) {
            if (dfsRecursive(i, j + 1, k + 1, s1, s2, s3)) {
                return true;
            }
        }

        return false;
    }

    private static Boolean[][] dp;

    public static boolean isInterLeave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        dp = new Boolean[m + 1][n + 1];
        return dfs(0, 0, 0, s1, s2, s3);
    }

    private static boolean dfs(int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length() && (i == s1.length()) && (j == s2.length())) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        dp[i][j] = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            dp[i][j] = dfs(i + 1, j, k + 1, s1, s2, s3);
        }
        if (!dp[i][j] && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            dp[i][j] = dfs(i, j + 1, k + 1, s1, s2, s3);
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(isInterLeaveRecursive("aabc", "abad", "aabadabc"));
        System.out.println(isInterLeave("aabc", "abad", "aabadabc"));
    }
}
