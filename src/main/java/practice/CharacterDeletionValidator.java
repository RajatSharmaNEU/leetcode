package practice;

import java.util.*;

public class CharacterDeletionValidator {

    public static boolean canDeleteOneChar(String str) {
        //Steps
        //1 - CharacterFrequencyMap - a:2, b:2, c:3
        //2 - DistinctFrequency - 2:2, 3:1
        //3 - DistinctFrequencyCount == 1 - True
        //4 - DistinctFrequencyCount > 2 - False
        //5 - If one frequency count is 1 then True else False

        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int freq : charFreqMap.values()) {
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);
        }

        if (freqMap.size() == 1) {
            return true;
        }

        if (freqMap.size() > 2) {
            return false;
        }

        List<Integer> freq = new ArrayList<>(freqMap.values());
        if (freq.get(0) == 1 || freq.get(1) == 1) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        // Test cases
        String str1 = "aabbc"; // Removing 'a' results in "abbc" with same frequency characters
        String str2 = "aabbccddd"; // Removing 'a', 'b', or 'c' will result in a string with different frequency characters
        String str3 = "aabbcccddd"; // Removing any character will result in a string with different frequency characters
        String str4 = "aaaaaaaa"; // Removing any character will result in a string with different frequency characters

        System.out.println(canDeleteOneChar(str1)); // Output: true
        System.out.println(canDeleteOneChar(str2)); // Output: false
        System.out.println(canDeleteOneChar(str3)); // Output: false
        System.out.println(canDeleteOneChar(str4)); // Output: false
    }
}

