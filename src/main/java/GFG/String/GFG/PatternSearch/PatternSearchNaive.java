package GFG.String.GFG.PatternSearch;

public class PatternSearchNaive {
    static void search(char[] pat, char[] txt) {
        int M = pat.length; // 4
        int N = txt.length; //

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            int j;

            /* For current index i, check for pattern match
             */
            for (j = 0; j < M; j++)
                if (pat[j] != txt[i + j])
                    break;

            // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }


    public static void main(String[] args) {
        char txt[] = "AABAACAADAABAAABAA".toCharArray();

        char pat[] = "AABA".toCharArray();

        // Function call
        search(pat, txt);
    }
}
