package Oracle;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // Deque - Add First, Remove, Remove Last
    // Or maintain Head and Tail
    // Map

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        // Map has key -> remove and addFirst
        // Map has no key -> -1

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addFirst(node);
            return node.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        // Map has key -> remove and add First
        // Map has no key -> Map addFirst key and removeLast(Map + Deque)

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addFirst(node);
            if (map.size() > capacity) {
                Node last = tail.prev;
                remove(last);
                map.remove(last.key);
            }
        }
    }
}
