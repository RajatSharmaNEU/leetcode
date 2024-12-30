package GFG.Heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestElement {
    public static class Element {
        int value;
        int index;

        Element(int v, int i) {
            this.value = v;
            this.index = i;
        }
    }

    public static void findKClosestElement(int[] arr, int x, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.value - o1.value;
            }
        });

        for (int i = 0; i < k; i++) {
            Element e = new Element(Math.abs(arr[i] - x), i);
            pq.add(e);
        }

        // now since we need min distance element so maintain min distance element in PQ
        for (int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            if(diff < pq.peek().value) {
                pq.poll();
                pq.add(new Element(diff, i));
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(arr[pq.poll().index]);
        }
    }

    public static void findKCloset(int[]arr, int ref, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[]{i, Math.abs(ref - arr[i])});
        }

        for (int i = 0; i < k; i++) {
            System.out.println(arr[pq.poll()[0]]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{30, 40, 32, 33, 36, 37};
        findKClosestElement(arr, 38, 3);
        findKCloset(arr, 38, 3);

    }
}
