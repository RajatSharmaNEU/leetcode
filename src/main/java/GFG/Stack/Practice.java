package GFG.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Practice {

    private void printPreviousGreatest(int[] arr) {
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


    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 18, 12, 4, 6, 2, 8};
        Practice practice = new Practice();
        practice.printPreviousGreatest(arr);
        System.out.println("-----");
//        practice.printPreviousGreatestStack(arr);
    }
}
