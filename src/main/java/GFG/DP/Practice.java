package GFG.DP;

public class Practice {
    private int findMaxCountCombination(int[] arr, int target, int index) {
        if (target <= 0 || index >= arr.length) {
            return 0;
        }

        int res = 0;
        for (int i = index; i < arr.length; i++) {
            if (target - arr[i] > 0) {
                res = arr[index] + findMaxCountCombination(arr, target - arr[i], index + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 5, 4, 3}; // {2,4,3}
//        int arr[] = new int[]{12, 15, 14, 13}; // {2,4,3}
        int target = 9;
        Practice practice = new Practice();
        System.out.println(practice.findMaxCountCombination(arr, target, 0));
    }
}
