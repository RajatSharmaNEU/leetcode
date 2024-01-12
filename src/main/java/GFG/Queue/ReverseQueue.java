package GFG.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    private void reverse(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return;
        }
        int elem = queue.poll();
        reverse(queue);
        System.out.println(elem);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        ReverseQueue reverseQueue = new ReverseQueue();
        reverseQueue.reverse(queue);
    }
}
