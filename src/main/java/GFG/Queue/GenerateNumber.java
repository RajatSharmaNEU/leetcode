package GFG.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumber {
    private void getCombination(String a, String b, int limit) {
        Queue<String> queue = new LinkedList<>();

        queue.add(a);
        queue.add(b);

        for (int i = 0; i < limit; i++) {
            String curr = queue.poll();
            queue.add(curr + a);
            queue.add(curr + b);
            System.out.println(curr);
        }
    }

    public static void main(String[] args) {
        GenerateNumber generateNumber = new GenerateNumber();
        generateNumber.getCombination("5", "6", 10);
    }
}
