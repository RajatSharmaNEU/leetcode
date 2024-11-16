package GFG.Stack;

import java.util.Stack;

public class HistogramArea {
    public int getMaxAreaBest(int[] arr) {
        // Here while element pop out then we evaluate popped out max area
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                int currMaxArea = arr[top] * width;
                res = Math.max(res, currMaxArea);
            }
            stack.push(i);
        }

        // for remaining element who does not have small element on right
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1;
            int currMaxArea = arr[top] * width;
            res = Math.max(res, currMaxArea);
        }

        return res;
    }

    public int getMaxAreaEfficient(int[] arr) {
        PreviousSmallestElement p = new PreviousSmallestElement();
        NextSmallestElement n = new NextSmallestElement();
        int[] ps = p.previousSmallestElements(arr);
        int[] ns = n.nextSmallestElements(arr);

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int leftArea = 0;
            int rightArea = 0;

            leftArea = (i - ps[i] - 1) * arr[i];

            if (ns[i] == -1) {
                ns[i] = arr.length;
            }

            rightArea = (ns[i] - i - 1) * arr[i];

//            System.out.println(leftArea + rightArea + arr[i]);
            result = Math.max(result, leftArea + rightArea + arr[i]);
        }
        return result;
    }

    public int getMaxArea(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int leftArea = 0, rightArea = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    leftArea = leftArea + arr[i];
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    rightArea = rightArea + arr[i];
                } else {
                    break;
                }

            }

//            System.out.println(leftArea + rightArea + arr[i]);
            result = Math.max(result, leftArea + rightArea + arr[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 5, 4, 1, 5, 6};
        HistogramArea histogramArea = new HistogramArea();
//        System.out.println(histogramArea.getMaxArea(arr));
//        histogramArea.previousSmallestElements(arr);
//        System.out.println("");
//        histogramArea.nextSmallestElements(arr);
        System.out.println(histogramArea.getMaxAreaEfficient(arr));
//        System.out.println(histogramArea.getMaxAreaBest(arr));
    }
}
