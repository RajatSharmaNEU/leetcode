package GFG.String;

import java.util.Arrays;

public class Practice {
    public static boolean areDistinct(int i, int j, String word) {
        int[] cache = new int[256];
        for (int k = i; k <= j; k++) {
            if (cache[word.charAt(k)] == 0) {
                cache[word.charAt(k)] = 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int ldcStringNaive3n(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (areDistinct(i, j, word)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    public static int ldcStringNaive2n(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            int[] cache = new int[256];
            for (int j = i; j < word.length(); j++) {
                if (cache[word.charAt(j)] == 1) {
                    break;
                } else {
                    result = Math.max(result, j - i + 1);
                    cache[word.charAt(j)] = 1;
                }
            }
        }
        return result;
    }

    public static int ldcStringNaive1n(String word) {
        int[] prevCache = new int[256];

        Arrays.fill(prevCache, -1);

        int result = 0;
        int startIndex = 0;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            startIndex = Math.max(startIndex, prevCache[curr] + 1);

            int len = i - startIndex;

            result = Math.max(result, len + 1);
            prevCache[curr] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        String string1 = "abcdabc";
        String string2 = "abcdapbacdefgh";
        String string3 = "abcdaaxyz";
//        System.out.println(ldcStringNaive3n(string1));
        System.out.println(ldcStringNaive3n(string2));
//        System.out.println(ldcStringNaive3n(string3));

//        System.out.println(ldcStringNaive2n(string1));
        System.out.println(ldcStringNaive2n(string2));
//        System.out.println(ldcStringNaive2n(string3));


//        System.out.println(ldcStringNaive1n(string1));
        System.out.println(ldcStringNaive1n(string2));
//        System.out.println(ldcStringNaive1n(string3));
    }
}
