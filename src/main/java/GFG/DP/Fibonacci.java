package GFG.DP;

import java.util.Arrays;

public class Fibonacci {
    // Recursion
    private int recursiveFibonacci(int n) {
        if( n <= 1) {
            return n;
        }

        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }


    // Memoization
    private int getFibonacci(int n, int[] memo) {
        if(memo[n] == Integer.MIN_VALUE) {
            if(n <= 1) {
                memo[n] = n;
            } else {
                memo[n] = getFibonacci(n-2, memo) + getFibonacci(n-1, memo);
            }
        }
        return memo[n];
    }
    private int getFibonacciMemo(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return getFibonacci(n, memo);
    }


    // Tabulation
    private int getFibonacciTabular(int n) {
        int[] table = new int[n+1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i-2] + table[i-1];
        }

        return table[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.recursiveFibonacci(6));
        System.out.println(fibonacci.getFibonacciMemo(6));
        System.out.println(fibonacci.getFibonacciTabular(6));
    }
}
