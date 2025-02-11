package GoldmanSachs.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheRaw {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;

    LRUCacheRaw(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.tail = new Node(-1, -1);
        this.head = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // addFirst -> Add Node next to Head
    public void addFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // remove -> Remove intermediate Node
    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addFirst(node);
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // if map has same key -> remove node and addFirst node
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        } else {
            if(map.size() == capacity) {
                Node lastNode = tail.prev;
                remove(lastNode);
                map.remove(lastNode.key);
            }

            Node node = new Node(key, value);
            addFirst(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCacheRaw lruCache = new LRUCacheRaw(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
