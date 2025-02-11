package GAMAM.Pattern;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        /*
        int missingCount = 0; // missing count
        int currNum = 1; // current number
        int index = 0; // index of array

        while(true) {
            if(index < arr.length && arr[index] == currNum) {
                index++;
            } else {
                missingCount++;
                if(missingCount == k) {
                    return currNum;
                }
            }
            currNum++;
        }
        */

        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            // {1,2,3,4,5}
            // {4,5,6,7,8}
            int missingBeforeMid = arr[mid] - (mid + 1);

            if(missingBeforeMid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k;
    }
}
