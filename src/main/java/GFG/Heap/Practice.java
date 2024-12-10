package GFG.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    public static void insert(int elem) {
        pq.offer(elem);

        System.out.println(Arrays.toString(pq.toArray()));
    }

    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        insert(5);
        System.out.println(pq.peek());
    }
}
