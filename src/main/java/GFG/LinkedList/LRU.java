package GFG.LinkedList;

import java.util.HashMap;

public class LRU {

    static class LRUCache {
        // get - access
        // put - add item to cache

        static int capacity = 3;
        static HashMap<Integer, Node> map = new HashMap<>();


        public static Node get(int key) {
            if (!map.containsKey(key)) {
                return null;
            }

            Node node = map.get(key);
            // if node is accessed, move it to front of DLL
            DLL.moveToHead(node);
            return node;
        }

        public static void put(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                DLL.moveToHead(node);
            } else {
                if (map.size() == capacity) {
                    Node tailNode = DLL.removeTail();
                    map.remove(tailNode.key);
                }

                Node newNode = new Node(key);
                DLL.addNode(newNode);
                map.put(key, newNode);
            }
        }
    }

    static class Node {
        int key;
        Node prev;
        Node next;

        Node() {

        }

        Node(int key) {
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

    static class DLL {
        // add node
        // move to head
        // remove tail
        // remove node

        static Node head;
        static Node tail;

        public static void addNode(Node node) {
            if(head ==null && tail ==null) {
                head = node;
                tail = node;
            }

            if(head != null) {
                node.next = head;
                head.prev = node;
            }

            head = node;
        }

        public static void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }

        public static Node removeTail() {
            tail = tail.prev;
            tail.next = null;
            removeNode(tail);
            return tail;
        }

        public static void removeNode(Node node) {
            if(node.prev != null) {
                node.prev.next = node.next;
            }
            if(node.next != null) {
                node.next.prev = node.prev;
            }
        }

        public static void traverse() {
            Node curr = head;
            while (curr != null) {
                System.out.println(curr.key);
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
//        DLL.addNode(new Node(10));
//        DLL.addNode(new Node(20));
//        DLL.addNode(new Node(30));
//        DLL.addNode(new Node(40));
//        DLL.traverse();

        LRUCache.put(10);
        LRUCache.put(20);
        LRUCache.put(30);
        LRUCache.get(10);
        LRUCache.put(40);
        LRUCache.get(30);
        DLL.traverse();
    }
}
