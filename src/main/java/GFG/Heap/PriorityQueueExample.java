package GFG.Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        System.out.println("Without any Comparator");
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Rajat");
        pq.add("Parth");
        pq.add("Renuka");

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());


        System.out.println("With reverse Comparator");
        PriorityQueue<String> pqString = new PriorityQueue<>(Collections.reverseOrder());
        pqString.add("Rajat");
        pqString.add("Parth");
        pqString.add("Renuka");

        System.out.println(pqString.peek());
        System.out.println(pqString.poll());
        System.out.println(pqString.poll());
        System.out.println(pqString.poll());

        System.out.println("Custom Comparator");

        PriorityQueue<String> pqCustom = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        pqCustom.add("Rajat");
        pqCustom.add("Parth");
        pqCustom.add("Renuka");

        System.out.println(pqCustom.peek());
        System.out.println(pqCustom.poll());
        System.out.println(pqCustom.poll());
        System.out.println(pqCustom.poll());


    }

}
