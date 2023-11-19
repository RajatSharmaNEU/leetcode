package Graph.Practice.Nov;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumber {
    public int countSteppingNumbers(String low, String high) {
        Queue<BigInteger> queue = new LinkedList<>();
        ArrayList<BigInteger> steppingNumbers = new ArrayList<>();

        BigInteger lowNum = new BigInteger(low);
        BigInteger highNum = new BigInteger(high);

        for (int i = 1; i < 10; i++) {
            queue.add(BigInteger.valueOf(i));
        }

        while (!queue.isEmpty()) {
            BigInteger num = queue.poll();

            if (num.compareTo(lowNum) >= 0 && num.compareTo(highNum) <= 0) {
//                System.out.println(num);
                steppingNumbers.add(num);
            }

            BigInteger lastDigit = num.mod(BigInteger.TEN);

            BigInteger next1 = num.multiply(BigInteger.TEN).add(lastDigit.add(BigInteger.ONE));
            BigInteger next2 = num.multiply(BigInteger.TEN).add(lastDigit.subtract(BigInteger.ONE));

            if (lastDigit.compareTo(BigInteger.valueOf(9)) < 0 && next1.compareTo(highNum) <= 0) {
                queue.add(next1);
            }

            if (lastDigit.compareTo(BigInteger.ZERO) > 0 && next2.compareTo(highNum) <= 0) {
                queue.add(next2);
            }
        }

        return steppingNumbers.size();
    }

    public static void main(String[] args) {
        SteppingNumber steppingNumber = new SteppingNumber();
//        System.out.println(steppingNumber.countSteppingNumbers("1", "11"));
        System.out.println(steppingNumber.countSteppingNumbers("79156681", "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
//        System.out.println(steppingNumber.countSteppingNumbers("90", "101"));
    }
}
