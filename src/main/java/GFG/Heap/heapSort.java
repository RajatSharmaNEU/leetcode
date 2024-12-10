package GFG.Heap;
import java.util.Arrays;

public class heapSort {
    static void buildHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void maxHeapify(int[] arr, int i, int n) {
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;
        int largest = i;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }

    static void doHeapSort(int[] arr) {
        int n = arr.length;
        // Step 1 - build Max Heap - from random to heap array
        buildHeap(arr, n);
        System.out.println(Arrays.toString(arr));

        // Step 2 - Repeatedly - swap + heapify(fix heap)
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 50, 4, 20};
        // do heap sort ~ n*log(n);

        doHeapSort(arr);
        System.out.println("Sol" + Arrays.toString(arr));
    }
}
