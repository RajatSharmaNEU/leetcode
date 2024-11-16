package GFG.Greedy.Neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraight {
    static public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            countMap.put(hand[i], countMap.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);

        for (int num : hand) {
            if (countMap.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (countMap.getOrDefault(i, 0) == 0) return false;
                    countMap.put(i, countMap.get(i) - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isNStraightHand(hand, 3));
    }
}
