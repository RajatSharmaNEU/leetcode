package GFG.String.NeetCode;

import java.util.HashMap;

public class PermutationExistInStrings {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hashMapS1 = new HashMap<>();
        HashMap<Character, Integer> hashMapS2 = new HashMap<>();

        int l = 0;

        for(int r = 0; r < s1.length(); r++) {
            hashMapS1.put(s1.charAt(r), hashMapS1.getOrDefault(s1.charAt(r), 0) + 1);
            hashMapS2.put(s2.charAt(r), hashMapS2.getOrDefault(s2.charAt(r), 0) + 1);
        }

        for(int r = s1.length(); r <= s2.length(); r++) {
            int count = 0;
            for(Character c: hashMapS1.keySet()){
                if(hashMapS1.get(c) == hashMapS2.get(c)) {
                    count++;
                }
            }

            if(count == hashMapS1.size()) return true;

            hashMapS2.put(s2.charAt(r), hashMapS2.getOrDefault(s2.charAt(r), 0) + 1);
            hashMapS2.put(s2.charAt(l), hashMapS2.get(s2.charAt(l)) - 1);
            l++;
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(checkInclusion("ab", "aaabc"));
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
