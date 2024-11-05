package GFG.DP.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordBreak {
    static public boolean wordBreak (String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length()-1; i >= 0 ; i--) {
            for(String word: wordDict) {
                if((i + word.length()) <= s.length() && s.startsWith(word, i)){
                    dp[i] = dp[i + word.length()];
                }

                if(dp[i]){
                    break;
                }

            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("leet", "code"));
        List<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "bbb", "bbbb"));
        List<String> list3 = new ArrayList<>(Arrays.asList("apple","pen"));
        System.out.println(wordBreak("neetleetcode", list));
        System.out.println(wordBreak("bb", list2));
        System.out.println(wordBreak("applepenapple", list3));
    }
}
