package GFG.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {
    public int[] nextSmallestElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ns = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ns[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(ns));
        return ns;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 5, 4, 1, 5, 6};
        NextSmallestElement histogramArea = new NextSmallestElement();
        System.out.println(histogramArea.nextSmallestElements(arr));
    }
}
