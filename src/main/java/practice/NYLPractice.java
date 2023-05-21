package practice;

import java.util.*;

public class NYLPractice {

    public static boolean canDeleteOneChar(String str) {
        // Step 1 - Create character n their count map --> charFrequencyMap
        // Step 2 - Create frequency n their count map --> frequencyMap
        // Step 3 - If one charFrequency --> true
        // Step 4 - If frequencyMap size > 2 --> false
        // Step 5 - If frequencyMap size == 2 then if anyone frequency == 1 ? true : false

        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        if (charFreqMap.size() == 1) return true;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int v : charFreqMap.values()) {
            freqMap.put(v, freqMap.getOrDefault(v, 0) + 1);
        }

        if (freqMap.size() > 2) return false;
        List<Integer> frequencies = new ArrayList<>(freqMap.values());


        if (frequencies.get(0) == 1 || frequencies.get(1) == 1) {
            return true;
        }

        return false;
    }

    public static String generateColumnName(int columnNumber) {
        // 1 -> A, 26 -> Z
        // 27 -> AA
        StringBuilder stringBuilder = new StringBuilder();

        if (columnNumber <= 0) return "Not a valid column number";

        while (columnNumber > 0) {
            int rem = (columnNumber - 1) % 26;
            int quotient = (columnNumber - 1) / 26;

            stringBuilder.append((char) ('A' + rem));
            columnNumber = quotient;
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "aabbc";
        String str2 = "aabbccddd";
        String str3 = "aabbcccddd";
        String str4 = "abbcc";

        System.out.println(canDeleteOneChar(str1)); // Output: true
        System.out.println(canDeleteOneChar(str2)); // Output: false
        System.out.println(canDeleteOneChar(str3)); // Output: false
        System.out.println(canDeleteOneChar(str4)); // Output: false

        System.out.println(generateColumnName(1));
        System.out.println(generateColumnName(26));
        System.out.println(generateColumnName(27));
        System.out.println(generateColumnName(28));
    }
}
