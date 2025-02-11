package BasicJava;

import java.util.stream.IntStream;

public class FibonacciSeries {
    public static int fibonacciStream(int num) {
        if (num <= 2) {
            return 1;
        }

        return IntStream.range(2, num)
                .boxed()
                .reduce(new int[]{1, 1}, // Initial Fibonacci pair {F(0), F(1)}
                        (acc, i) -> new int[]{acc[1], acc[0] + acc[1]}, // Generate next Fibonacci pair
                        (a, b) -> b // Combiner (not used here)
                )[1]; // Return F(n-1)
    }

    public static int fibonacci(int num) {
        int[] dp = new int[num];

        if(num <= 2) {
            return 1;
        }

        // initializing it
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < num; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[num - 1];
    }

    public static void main(String[] args) {
        // fibonacci Series
        // 1, 1, 2, 3, 5, 8, 13
        // Recursion, DP - Tabulation or Recursive
        System.out.println(fibonacci(4));
        System.out.println(fibonacciStream(4));
    }
}
