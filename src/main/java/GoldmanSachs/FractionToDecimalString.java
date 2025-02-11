package GoldmanSachs;

import java.util.HashMap;

public class FractionToDecimalString {
    public static String fractionToDecimal(int numerator, int denominator) {
        // Approach
        // Case 1 - numerator > denominator && remainder is 0
        // Case 2.1 - numerator > denominator && remainder is not 0
        // Case 2.2 - numerator < denominator
        // Case 2.3 - repeating

        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }

        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Determine the sign of the result
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with absolute values to avoid issues with negative numbers
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part of the division
        result.append(num / den);

        // Compute the remainder
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        // Append the decimal point
        result.append(".");

        // Use a map to store the remainder and its position in the result
        HashMap<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            // Check if the remainder is already seen
            if (remainderMap.containsKey(remainder)) {
                int startIndex = remainderMap.get(remainder);
                result.insert(startIndex, "(");
                result.append(")");
                break;
            }

            // Store the position of this remainder
            remainderMap.put(remainder, result.length());

            // Multiply the remainder by 10 to continue the division
            remainder *= 10;
            result.append(remainder / den);

            // Update the remainder
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2)); // Output: "0.5"
        System.out.println(fractionToDecimal(2, 3)); // Output: "0.(6)"
        System.out.println(fractionToDecimal(4, 333)); // Output: "0.(012)"
        System.out.println(fractionToDecimal(1, 5)); // Output: "0.2"
        System.out.println(fractionToDecimal(-50, 8)); // Output: "-6.25"
        System.out.println(fractionToDecimal(0, -5)); // Output: "0"
        System.out.println(fractionToDecimal(1, -6)); // Output: "-0.1(6)"
    }
}
