package Graph.Problems.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumber {

    // Brute Approach using iterative - Time Complexity N
//    public static boolean steppingNumber(int[] digits, int index) {
//        // 123
//        if (digits.length == 1 || index+1 == digits.length) {
//            return true;
//        }
//        if (digits[index] + 1 != digits[index + 1] || digits[index] - 1 == digits[index + 1]) {
//            return steppingNumber(digits, index + 1);
//        } else {
//            return false;
//        }
//
//    }
//
//    public static int[] stepnum(int A, int B) {
//        ArrayList<Integer> result = new ArrayList<>();
//
//        for (int i = A; i <= B; i++) {
//            int[] digits = Integer.toString(i).chars().map(c -> c - '0').toArray();
//            if (steppingNumber(digits, 0)) {
//                result.add(i);
//            }
//        }
//
//        return result.stream().mapToInt(i -> i).toArray();
//    }

    public static ArrayList<Integer> BFS(int A, int B) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            if(current >=A && current <= B) {
                result.add(current);
            }

            int lastDigit = current % 10;

            if (lastDigit + 1 <=9 && current * 10 + lastDigit + 1 <= B) {
                q.add(current * 10 + lastDigit + 1);
            }

            if (lastDigit - 1 > 0 && current * 10 + lastDigit - 1 <= B) {
                q.add(current * 10 + lastDigit - 1);
            }
        }

        return result;
    }

    public static void DFSRecursive(int num, int A, int B, ArrayList<Integer> result) {
        if (num > B) {
            return;
        }

        if (num >= A && num <= B) {
            result.add(num);
        }

        int lastDigit = num % 10;

        if (lastDigit != 0) {
            DFSRecursive(num * 10 + lastDigit - 1, A, B, result);
        }

        if (lastDigit != 9) {
            DFSRecursive(num * 10 + lastDigit + 1, A, B, result);
        }
    }

    public static ArrayList<Integer> DFS(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            DFSRecursive(i, A, B, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int A = 0, B = 86;
//        ArrayList<Integer> result  = DFS(A, B);
        ArrayList<Integer> result  = BFS(A, B);

        if (A == 0) {
            result.add(0);
        }

        int[] output = result.stream().mapToInt(i -> i).toArray();

        Arrays.sort(output);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
