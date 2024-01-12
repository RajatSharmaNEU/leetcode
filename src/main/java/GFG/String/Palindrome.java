package GFG.String;

public class Palindrome {
    // Space O(1) and Time O(n)
    private boolean isPalindromeEfficient(String string) {
        int low = 0;
        int high = string.length() - 1;

        while (low < high) {
            if(string.charAt(low) != string.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    // // Space O(n) and Time O(n)
    private boolean isPalindromeNaive(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return string.equals(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        String string = "ABCBA";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindromeNaive(string));
        System.out.println(palindrome.isPalindromeEfficient(string));
    }
}
