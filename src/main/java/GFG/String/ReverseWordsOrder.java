package GFG.String;

import java.util.Arrays;

public class ReverseWordsOrder {
    private void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    private void reverseWords(String string) {
        char[] chars = string.toCharArray();

        // Reverse individual words
        int low = 0;
        for (int high = 0; high < string.length(); high++) {
            if (chars[high] == ' ') {
                reverse(chars, low, high - 1);
                low = high + 1;
            }
        }

        // reverse last word
        reverse(chars, low, chars.length-1);

        // reverse entire
        reverse(chars, 0, chars.length-1);

        System.out.println(chars);
    }

    public static void main(String[] args) {
        String string = "Welcome to the leetcode";
        ReverseWordsOrder reverseWordsOrder = new ReverseWordsOrder();
        reverseWordsOrder.reverseWords(string);
    }
}
