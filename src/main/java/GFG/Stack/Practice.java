package GFG.Stack;

import java.util.Stack;

public class Practice {

    // O(n)
    private void printSpanUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(1);
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            System.out.println("Stack Peek - " + stack.peek());
            System.out.println(stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
        }
    }

    // Problem ~ O(n2)
    private void printSpan(int[] arr) {
        // loop
        // inner loop from i to 0 and condition prev element less than current

        System.out.println(1);
        for (int i = 1; i < arr.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    count++;
                } else {
                    break;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{60, 10, 20, 15, 35, 50};
        Practice stockSpan = new Practice();
//        stockSpan.printSpan(arr);
        stockSpan.printSpanUsingStack(arr);
    }
}
