package GFG.Stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallestElement {
    public int[] previousSmallestElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            ps[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(ps));
        return ps;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 5, 4, 1, 5, 6};
        PreviousSmallestElement histogramArea = new PreviousSmallestElement();
        System.out.println(histogramArea.previousSmallestElements(arr));
    }
}
