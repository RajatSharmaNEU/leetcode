package Oracle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelSubstring {
    public int countVowelSubstrings(String word) {
        int n = word.length(), count = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < n; i++) {
            Set<Character> seenVowels = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (!vowels.contains(c)) break; // Stop if a non-vowel is encountered

                seenVowels.add(c);
                if (seenVowels.size() == 5) count++;
            }
        }

        return count;
    }
}
