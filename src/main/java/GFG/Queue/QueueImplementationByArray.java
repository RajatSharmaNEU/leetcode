package GFG.Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementationByArray {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new ArrayDeque();

        try {

            System.out.println(queue1.offer(0));
            System.out.println(queue1.peek());
            System.out.println(queue1.poll());
            System.out.println(queue1.poll());

            System.out.println("Below Methods can throw exceptions");

            System.out.println(queue2.add(1));
            System.out.println(queue2.element());
            System.out.println(queue2.remove());
            System.out.println(queue2.remove());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }
}
