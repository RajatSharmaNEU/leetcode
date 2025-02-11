package GoldmanSachs.LRUCache;

//https://leetcode.com/problems/design-circular-deque/
class MyCircularDeque {
    int[] deque;
    int front;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
        front = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }

        front = ((front - 1) + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }

        // front - 0, size - 3, 0 + 3 + 1 = 4 % 5 = 4
        // front - 3, size - 3, 3 + 3 + 1 = 7 % 5 = 2

        int last = (front + size) % capacity;
        deque[last] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(size == 0) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(size == 0) {
            return false;
        }

        size--;
        return true;
    }

    public int getFront() {
        if(size == 0) {
            return -1;
        }

        return deque[front];
    }

    public int getRear() {
        if(size == 0) {
            return -1;
        }

        int last = (front + size - 1) % capacity;
        return deque[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
