package GFG.Stack;

import java.util.Stack;

public class NextGreatestElement {
    private void printNextGreatestStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        for (int i = arr.length-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }
            result.push(stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr[i]);
        }

        while (!result.isEmpty()){
            System.out.println(result.pop());
        }
    }
    private void printNextGreatest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j <= arr.length; j++) {
                if(j == arr.length) {
                    System.out.println(-1);
                    break;
                }

                if(arr[j] > arr[i]) {
                    System.out.println(arr[j]);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 8, 6, 12, 9, 18};
        NextGreatestElement nextGreatestElement = new NextGreatestElement();
        nextGreatestElement.printNextGreatest(arr);
        System.out.println("-------------");
        nextGreatestElement.printNextGreatestStack(arr);
    }
}
