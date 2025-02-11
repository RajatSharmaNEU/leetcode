package GFG.Stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreatestElement {

    private void printPreviousGreatestStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(-1);
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }
            int res = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(res);
            stack.push(arr[i]);
        }
    }

    private void printPreviousGreatestUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(result));
    }

    private void printPreviousGreatest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    System.out.println(arr[j]);
                    break;
                }
                if (j == 0) {
                    System.out.println(-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 18, 12, 4, 6, 2, 8};
        PreviousGreatestElement previousGreatestElement = new PreviousGreatestElement();
        previousGreatestElement.printPreviousGreatest(arr);
        System.out.println("-----");
        previousGreatestElement.printPreviousGreatestUsingStack(arr);
    }
}
