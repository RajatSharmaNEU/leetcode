package GFG.String;

import java.util.Arrays;

public class LeftMostRepeat {
    private int usingVisited(String string) {
        boolean[] visited = new boolean[256];

        int result = Integer.MAX_VALUE;
        for (int i = string.length() - 1; i >= 0; i--) {
            if(visited[string.charAt(i)]) {
                result = Math.min(result, i);
            } else {
                visited[string.charAt(i)] = true;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int usingArray(String string) {
        int[] count = new int[256];

        Arrays.fill(count, -1);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < string.length(); i++) {
            int indexOfRepeatChar = count[string.charAt(i)];

            if (indexOfRepeatChar == -1) {
                count[string.charAt(i)] = i;
            } else {
                result = Math.min(result, indexOfRepeatChar);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int usingStringMethod(String string) {
        for (int i = 0; i < string.length(); i++) {
            Character curr = string.charAt(i);
            if (string.indexOf(curr) != string.lastIndexOf(curr)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input1 = "geeksforgeeks";
        String input2 = "abbcc";
        String input3 = "abcd";
        LeftMostRepeat leftMostRepeat = new LeftMostRepeat();

        System.out.println("With using string methods");
        System.out.println(leftMostRepeat.usingStringMethod(input1));
        System.out.println(leftMostRepeat.usingStringMethod(input2));
        System.out.println(leftMostRepeat.usingStringMethod(input3));

        System.out.println("Without using string methods - int Array 256 length");
        System.out.println(leftMostRepeat.usingArray(input1));
        System.out.println(leftMostRepeat.usingArray(input2));
        System.out.println(leftMostRepeat.usingArray(input3));

        System.out.println("Without using string methods - bool visited Array 256 length");
        System.out.println(leftMostRepeat.usingVisited(input1));
        System.out.println(leftMostRepeat.usingVisited(input2));
        System.out.println(leftMostRepeat.usingVisited(input3));
    }
}
