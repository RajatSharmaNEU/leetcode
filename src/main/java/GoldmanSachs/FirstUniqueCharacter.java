package GoldmanSachs;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        char[] cache = new char[26];

        for (char c : s.toCharArray()) {
            if (cache[c - 'a'] < 2) {
                cache[c - 'a']++;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(cache[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
