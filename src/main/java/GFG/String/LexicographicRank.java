package GFG.String;

public class LexicographicRank {
    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // O(n + 256 + n * 256) --> O(n * 256)
    private int getRank(String string) {
        // First calculate Rank of the characters as per their order
        // STRING - (GINRTS ~ 123456)
        int[] count = new int[256];

        // O(n)
        for (int i = 0; i < string.length(); i++) {
            count[string.charAt(i)]++; // STRING - 11111
        }

        // O(256)
        for (int i = 1; i < 256; i++) {
            count[i] = count[i] + count[i - 1]; // STRING - 5,6,4,2,3,1  ~ A to F - 0, G to F - 1, I - M - 2, N - Q - 3 ...
        }

        // Second find combination count by fixing characters
        int result = 0;
        // O(n)
        for (int i = 0; i < string.length(); i++) {
            // num of characters smaller than current element * remaining place factorial
            int rank = string.charAt(i);
            int remainingPositions = string.length() - 1 - i;
            result = result + (count[rank - 1] * factorial(remainingPositions));

            // for next iteration we have to update position of characters
            // Character bigger and equal are now have order one less
            // O(256)
            for (int j = string.charAt(i); j < 256; j++) {
                count[j]--;
            }
        }

        return result + 1;
    }

    public static void main(String[] args) {
        LexicographicRank lexicographicRank = new LexicographicRank();
//        System.out.println(lexicographicRank.factorial(6));
        System.out.println(lexicographicRank.getRank("STRING"));
    }
}
