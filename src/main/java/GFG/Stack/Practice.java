package GFG.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Practice {
    public static int[] prevGreatest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    public static int[] prevSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    public static int[] nextGreatest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    public static int[] nextSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    public static int histogramArea(int[] arr) {
        int[] ps = prevSmallest(arr);
        int[] ns = nextSmallest(arr);

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int leftArea = 0, rightArea = 0;

            leftArea = (i - ps[i] - 1) * arr[i];

            if(ns[i] == -1) {
                ns[i] = arr.length;
            }

            rightArea = (ns[i] - i - 1) * arr[i];

            res = Math.max(res, leftArea + rightArea + arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 18, 12, 4, 6, 2, 8};
                            //[0,  1,  2,  3, 4, 5, 6, 7]
        System.out.println(Arrays.toString(prevGreatest(arr))); // [-1, 0, -1, 2, 3, 3, 5, 3]
        System.out.println(Arrays.toString(prevSmallest(arr))); // [-1, -1, 1, 1, -1, 4, -1, 6]
        System.out.println(Arrays.toString(nextGreatest(arr))); // [2, 2, -1, -1, 5, 7, 7, -1]
        System.out.println(Arrays.toString(nextSmallest(arr))); // [1, 4, 3, 4, 6, 6, -1, -1]

        System.out.println(histogramArea(arr));
    }
}
