package GFG.Heap;

import java.util.Arrays;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    MinHeap(int c) {
        arr = new int[c];
        this.size = 0;
        this.capacity = c;
    }

    int left(int i) { // left of an element at index i in array
        return 2 * i + 1;
    }

    int right(int i) { // right of an element at index i in array
        return 2 * i + 2;
    }

    int parent(int i) { // // parent of an element at index i in array
        return (i - 1) / 2;
    }

    void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // insert new element and maintain min heap data structure
    void insert(int x) {
        if (size == capacity) return;
        size++;
        arr[size - 1] = x;

        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; i = parent(i)) {
            // Swap i <--> parent(i)
            swap(arr, i, parent(i));
        }
    }

    // Convert not-minHeap into minHeap
    void minHeapify(int i) {
        int l = left(i), r = right(i);
        int smallest = i;

        if (l < size && arr[l] < arr[smallest]) {
            smallest = l;
        }

        if (r < size && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            swap(arr, smallest, i);
            minHeapify(smallest);
        }
    }

    // extract min which is top and maintain min Heap
    int extractMin() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }

        if (size == 1) {
            size--;
            return arr[0];
        }

        swap(arr, 0, size - 1);
        size--;
        minHeapify(0);

        return arr[size];
    }

    // decrease key - replace ith element with less value x
    void decreaseKey(int i, int x) {
        arr[i] = x;

        while (i!= 0 && arr[parent(i)] > arr[i]) {
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    // delete element - better to replace element with -Infinity and extract min
    void delete(int i) { // 2*log(n)
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // build heap from random array - O(n)
    void buildHeap() {
        for (int i = (size-2)/2; i >=0 ; i--) {
            minHeapify(i);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(80);

        System.out.println("Before insert 12 " + Arrays.toString(minHeap.arr));
        minHeap.insert(12);
        System.out.println("After insert 12 " + Arrays.toString(minHeap.arr));

        MinHeap minHeapForHeapify = new MinHeap(10);
        minHeapForHeapify.insert(10);
        minHeapForHeapify.insert(20);
        minHeapForHeapify.insert(30);
        minHeapForHeapify.insert(35);
        minHeapForHeapify.insert(25);
        minHeapForHeapify.insert(80);
        minHeapForHeapify.insert(32);
        minHeapForHeapify.insert(100);
        minHeapForHeapify.insert(70);
        minHeapForHeapify.insert(60);

        minHeapForHeapify.arr[0] = 40;

        System.out.println("Before Fixing Heap " + Arrays.toString(minHeapForHeapify.arr));
        minHeapForHeapify.minHeapify(0);
        System.out.println("After Fixing Heap " + Arrays.toString(minHeapForHeapify.arr));

        System.out.println("Extract Min Element " + minHeapForHeapify.extractMin());
        System.out.println("After Min Element Extracted Heap " + Arrays.toString(minHeapForHeapify.arr));
        System.out.println("After Min Element Extracted Heap Size " + minHeapForHeapify.size);
        minHeapForHeapify.insert(150);
        System.out.println("After Inserting 150 " + Arrays.toString(minHeapForHeapify.arr));

        minHeapForHeapify.delete(3);
        System.out.println("After deleting 60 " + Arrays.toString(minHeapForHeapify.arr));
    }
}
