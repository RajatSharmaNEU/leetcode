package GAMAM.Pattern;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = findDigitSum(n);
        }

        return n == 1;
    }

    public static boolean isHappyFlyod(int n) {
       int slow = n;
       int fast = findDigitSum(n);

       while (fast != 1 && slow != fast) {
           slow = findDigitSum(slow);
           fast = findDigitSum(findDigitSum(fast));
       }

       return fast == 1;
    }

    public static int findDigitSum(int n) {
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            sum = sum + (digit * digit);
            n = n / 10;
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(2));
        System.out.println(isHappyFlyod(2));

        System.out.println(isHappy(19));
        System.out.println(isHappyFlyod(19));
    }
}
