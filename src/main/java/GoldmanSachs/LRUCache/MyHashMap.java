package GoldmanSachs.LRUCache;

import java.util.LinkedList;


/*
* put - If for a key, bucket is null then set bucket as new Node(-1, -1) // LINE - 50
* getNode/findNode - Use prev and return prev // LINE - 35
* */
class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // GetIndex
    private int getIndex(int key) {
        return key % SIZE;
    }

    // GetNode
    private Node getNode(int key, Node head) {
        Node prev = null;

        while (head != null && head.key != key) {
            prev = head;
            head = head.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getIndex(key);

        // initial bucket if empty
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1);
        }

        Node prev = getNode(key, buckets[index]);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }

    }

    public int get(int key) {
        int index = getIndex(key);

        Node bucketHead = buckets[index];

        if (bucketHead == null) {
            return -1;
        }

        Node prev = getNode(key, bucketHead);

        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node bucketHead = buckets[index];

        if (bucketHead == null) {
            return;
        }

        Node prev = getNode(key, bucketHead);

        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

class MyHashMapLinkedList {
    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static final int SIZE = 1000;
    LinkedList<Node>[] buckets;

    public MyHashMapLinkedList() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private Node findNode(int key, LinkedList<Node> bucket) {
        for (Node node : bucket) {
            if (node.key == key) {
                return node;
            }
        }

        return null;
    }

    public void put(int key, int value) {
        // find Index
        int index = getIndex(key);
        // findNode
        LinkedList<Node> bucket = buckets[index];
        Node node = findNode(key, bucket);
        // add or update
        if (node == null) {
            bucket.add(new Node(key, value));
        } else {
            node.value = value;
        }

    }

    public int get(int key) {
        // find Index
        int index = getIndex(key);
        // findNode
        LinkedList<Node> bucket = buckets[index];
        Node node = findNode(key, bucket);
        return node == null ? -1 : node.value;
    }

    public void remove(int key) {
        // find Index
        int index = getIndex(key);
        // findNode
        LinkedList<Node> bucket = buckets[index];
        Node node = findNode(key, bucket);

        if(node != null) {
            bucket.remove(node);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */