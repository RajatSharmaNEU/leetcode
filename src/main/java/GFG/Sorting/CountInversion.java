package GFG.Sorting;

public class CountInversion {
    // O(n^2)
    public static int countNaive(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    // O(NlogN)
    // 2, 4, 1, 3, 5
    // 1 need two moves and 3 need one move ~ 3 total moves to sort is the answer
    public static int mergeSort(int[] arr, int left, int right) {
        int res = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            res += mergeSort(arr, left, mid);
            res += mergeSort(arr, mid + 1, right);
            res += countMergeSort(arr, left, right, mid);
        }
        return res;
    }

    public static int countMergeSort(int[] arr, int l, int r, int m) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + i + 1];
        }

        int res = 0, i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res = res + (n1 - i);
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 4, 1, 3, 5};
        System.out.println(countNaive(arr1));
        System.out.println(mergeSort(arr1, 0, arr1.length - 1));
    }
}
