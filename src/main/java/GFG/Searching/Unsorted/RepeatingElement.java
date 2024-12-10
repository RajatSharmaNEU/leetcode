package GFG.Searching.Unsorted;

public class RepeatingElement {
    // Space & Time - O(n)
    public static int find(int[] arr) {
//        HashSet<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
            } else {
                return arr[i];
            }
        }
        return -1;
    }

    // Space - O(1) & Time - O(n)
    public static int findEfficient(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while (slow != fast);

        slow = arr[0] + 1;

        while (slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }

        return slow - 1;

    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 2, 1, 3, 2, 2};
        int[] arr2 = new int[]{1, 2, 3, 0, 3, 4, 5};
        int[] arr3 = new int[]{0, 0};

        System.out.println(find(arr1));
        System.out.println(find(arr2));
        System.out.println(find(arr3));

        System.out.println(findEfficient(arr1));
        System.out.println(findEfficient(arr2));
        System.out.println(findEfficient(arr3));

    }
}
