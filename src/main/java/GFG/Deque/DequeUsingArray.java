package GFG.Deque;

// Deque using Array with Time Complexity O(1)
// Use circular implementation on array

import java.util.Arrays;

public class DequeUsingArray {
    int front, cap, size;
    int[] arr;

    DequeUsingArray(int capacity) {
        arr = new int[capacity];
        cap = capacity;
        front = 0;
        size = 0;
    }

    // Methods
    // get rear
    private int getRear() {
        if (isEmpty()) return -1;
        return (front + size - 1) % cap;
    }

    // get Front
    private int getFront() {
        if (isEmpty()) return -1;
        return front;
    }

    // Insert Front
    private void insertFront(int x) {
        if (isFull()) return;
        // front moves on left hence reduce by 1 but add cap otherwise front is in negative
        // Do % cap as it is circular
        front = (front - 1 + cap) % cap;
        arr[front] = x;
        size++;
    }

    // Insert Rear
    private void insertRear(int x) {
        if (isFull()) return;
        // Rear moves right hence increase by 1
        // Do % cap as it is circular
        int rear = (getRear() + 1) % cap;
        arr[rear] = x;
        size++;
    }

    // Delete Front
    private void deleteFront() {
        if (isEmpty()) return;
        // front on deletion increase by 1
        front = (front + 1) % cap;
        size--;
    }

    // Delete Rear
    private void deleteRear() {
        if (isEmpty()) return;
        size--;
    }

    // getSize
    // isEmpty
    private boolean isEmpty() {
        return size == 0;
    }

    // isFull
    private boolean isFull() {
        return size == cap;
    }

    public static void main(String[] args) {
        DequeUsingArray deque = new DequeUsingArray(4);
        System.out.println("Initial State - " + Arrays.toString(deque.arr));
        deque.insertFront(10);
        System.out.println("Insert Front 10 - " + Arrays.toString(deque.arr));
        deque.insertRear(20);
        System.out.println("Insert Rear 20 - " + Arrays.toString(deque.arr));
        deque.insertRear(30);
        System.out.println("Insert Rear 30 - " + Arrays.toString(deque.arr));
        deque.deleteFront();
        System.out.println("Delete Front - " + Arrays.toString(deque.arr));
        deque.deleteRear();
        System.out.println("Delete Rear - " + Arrays.toString(deque.arr));
    }

}
