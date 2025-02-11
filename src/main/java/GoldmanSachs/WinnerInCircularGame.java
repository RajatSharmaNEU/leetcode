package GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class WinnerInCircularGame {
    // Time Complexity - O(n^2)
    public static int bruteForce(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int start = 0;

        while (list.size() > 1) {
            int elemToRemove = (start + k - 1) % list.size();
            list.remove(elemToRemove);
            start = elemToRemove;
        }

        return list.get(0);
    }

    public static int helper(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (helper(n - 1, k) + k) % n;
    }

    public static int recursive(int n, int k) {
        return helper(n, k) + 1;
    }

    public static int iterative(int n, int k) {
        int start = 0;

        for (int players = 2; players <= n ; players++) {
            start = (start + k) % players;
        }

        return start + 1;
    }

    public static void main(String[] args) {
        int n = 5, k = 2;

        System.out.println(bruteForce(n, k));
        System.out.println(recursive(n, k));
        System.out.println(iterative(n, k));
    }
}
