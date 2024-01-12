package GFG.Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementationByArray {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new ArrayDeque();

        try {
//            queue2.element();
            queue2.remove();
            queue2.add(1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
