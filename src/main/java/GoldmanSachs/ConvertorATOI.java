package GoldmanSachs;

public class ConvertorATOI {
    public static int myAtoi(String s) {
        // Challenge
        // Step 1 - Ignore white spaces
        // Step 2 - +/-
        // Step 3 - Add numbers till character encounter
        // Step 4 - Handle overflow 32 bit

        // Strategy - Use int not string

        int index = 0; // string index
        int n = s.length();
        int result = 0;
        int sign = 1;

        // Step 1 - Ignore white spaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2 - Sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // Step 3 - Add numbers till character encounter
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Step 4 - Handle Out of Range
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = ((result * 10) + digit);
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42")); // Output: 42
        System.out.println(myAtoi("   -42")); // Output: -42
        System.out.println(myAtoi("4193 with words")); // Output: 4193
        System.out.println(myAtoi("words and 987")); // Output: 0
        System.out.println(myAtoi("-91283472332")); // Output: -2147483648 (Integer.MIN_VALUE)
    }
}
