package Oracle;

import java.util.Arrays;
import java.util.Map;

public class PrimeEvenOddSort {
    public static int[] sortPrimesEvenOdd(int[] arr) {
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArray, (a, b) -> {
            int groupA = getGroup(a);
            int groupB = getGroup(b);

            if(groupA != groupB) {
                return groupA - groupB;
            }

            return a - b;
        });

        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }

    public static int getGroup(int num) {
        if(isPrime(num)) return 0;
        if(num % 2 == 0) return 1;
        return 2;
    }

    public static boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for (int i = 3; i <= (int)Math.sqrt(num); i = i + 2) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 4, 9, 11, 7};

        System.out.println(Arrays.toString(sortPrimesEvenOdd(arr)));
    }
}
