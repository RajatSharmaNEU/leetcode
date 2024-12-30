package GFG.LinkedList;

import java.util.LinkedList;

public class Practice {
    private static int capacity = 3;
    private static LinkedList<Node> cache = new LinkedList<>();

    private static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // put

    private static void put(int key, int value) {
        // if key exist, move it to first
        // if capacity is full, removeLast

        for (int i = 0; i < cache.size(); i++) {
            Node curr = cache.get(i);
            if(curr.key == key) {
                cache.remove(i);
                cache.addFirst(new Node(key, value));
                return;
            }
        }

        if(cache.size() >= capacity) {
            cache.removeLast();
        }

        cache.addFirst(new Node(key, value));

    }
    // get
    // display

    public static void main(String[] args) {
        Practice lruCache = new Practice();

        lruCache.put(1, 100);
        lruCache.put(2, 200);
        lruCache.put(3, 300);
        lruCache.put(2, 300);

        for (Node node : cache) {
            System.out.print("(" + node.key + ":" + node.value + ") ");
        }
    }
}
