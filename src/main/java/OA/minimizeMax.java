package OA;

public class minimizeMax {
    public static boolean canAchieveMax(int[] arr, int mid) {
        int avail = 0;
        for (int el : arr) {
            if (el <= mid) {
                avail += mid - el;
            } else if ((el - avail) <= mid) {
                avail -= el - mid;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int element : arr) {
            max = Math.max(max, element);
        }
        return max;
    }

    public static int minimizeMax(int[] arr) {
        int i = 0;
        int j = max(arr);

        while (i < j - 1) {
            int mid = (i + j) / 2;

            if (canAchieveMax(arr, mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        if (canAchieveMax(arr, i)) {
            return i;
        } else {
            return j;
        }
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 5, 7, 6};
        int[] input2 = new int[]{5, 15, 19};
        int[] input3 = new int[]{10, 3, 5, 7};
        System.out.println(minimizeMax(input1));
        System.out.println(minimizeMax(input2));
        System.out.println(minimizeMax(input3));
    }
}
