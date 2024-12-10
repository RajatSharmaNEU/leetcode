package GFG.String.PatternSearch;

import java.util.Arrays;

// Find common longest prefix suffix length
public class LongestPrefixSuffixLength {

    void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String pat = "ababc";
        LongestPrefixSuffixLength longestPrefixSuffixLength = new LongestPrefixSuffixLength();
        int[] lps = new int[pat.length()];
        longestPrefixSuffixLength.computeLPSArray(pat, pat.length(), lps);

        Arrays.stream(lps).forEach(System.out::print);

    }
}
