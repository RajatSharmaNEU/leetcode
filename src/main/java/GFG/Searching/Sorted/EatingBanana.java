package GFG.Searching.Sorted;

import java.util.Arrays;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class EatingBanana {
    public static int minEatingSpeedNaive(int[] piles, int h) {
        int maxSpeed = Arrays.stream(piles).max().getAsInt();

        for (int speed = 1; speed < maxSpeed; speed++) {
            int totalTime = 0;
            for (int j = 0; j < piles.length; j++) {
                totalTime += (int)Math.ceil((double)piles[j] / speed);
            }

            if(totalTime <= h) {
                return speed;
            }
        }

        return maxSpeed;
    }

    public static int minEatingSpeedBinary(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int totalTime = 0;
            for (int j = 0; j < piles.length; j++) {
                totalTime += (int)Math.ceil((double)piles[j] / mid);
            }

            if(totalTime <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3,6,7,11};
        int[] arr2 = new int[]{30,11,23,4,20};
        System.out.println(minEatingSpeedNaive(arr1, 8));
        System.out.println(minEatingSpeedBinary(arr1, 8));

        System.out.println(minEatingSpeedNaive(arr2, 6));
        System.out.println(minEatingSpeedBinary(arr2, 6));
    }
}
