package GFG.Stack;

import java.util.Stack;

public class StockSpan {
    private void printSpanUsingStack(int[] arr) {
        // Stack will maintain index of items in decreasing order
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        System.out.println(0 + "-" + 1);

        for (int i = 1; i < arr.length; i++) {
            // remove items from stack whose value is less than current items
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            int res = stack.isEmpty() ? i + 1 : i - stack.peek();
            System.out.println( i+ "-" +res);
            stack.push(i);
        }
    }

    private void printSpan(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int span = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    span++;
                } else {
                    break;
                }
            }
            System.out.println(i + " - " + span);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{60, 10, 20, 15, 35, 50};
        StockSpan stockSpan = new StockSpan();
        stockSpan.printSpan(arr);
        stockSpan.printSpanUsingStack(arr);
    }
}
