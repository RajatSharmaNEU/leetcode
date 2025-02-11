package GoldmanSachs.LRUCache;

import java.util.NoSuchElementException;

// https://leetcode.com/problems/design-circular-deque/
public class CustomDeque {

    // Node class for internal representation
    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public CustomDeque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add an element at the front
    public void addFirst(int data) {
        Node newNode = new Node(data);
        //TODO: This is important
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add an element at the rear
    public void addLast(int data) {
        Node newNode = new Node(data);
        //TODO: This is important
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove an element from the front
    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        int data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    // Remove an element from the rear
    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        int data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    // Peek at the first element
    public int peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return head.data;
    }

    // Peek at the last element
    public int peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return tail.data;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the deque
    public int size() {
        return size;
    }

    // Clear the deque
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomDeque deque = new CustomDeque();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(25);

        System.out.println("First element: " + deque.peekFirst()); // Output: 5
        System.out.println("Last element: " + deque.peekLast());  // Output: 25

        System.out.println("Removed first: " + deque.removeFirst()); // Output: 5
        System.out.println("Removed last: " + deque.removeLast());   // Output: 25

        System.out.println("Size: " + deque.size()); // Output: 2
        deque.clear();
        System.out.println("Is deque empty? " + deque.isEmpty()); // Output: true
    }
}
