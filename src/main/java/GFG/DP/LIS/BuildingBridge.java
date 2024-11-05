package GFG.DP.LIS;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
public class BuildingBridge {
    private int bb(int[][] cityPairs) {
        // 1. sort arr with first value then second value
        Arrays.sort(cityPairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] cityPair1, int[] cityPair2) {
                if (cityPair1[0] == cityPair2[0]) {
                    return cityPair1[1] - cityPair2[1];
                }

                return cityPair1[0] - cityPair2[0];
            }
        });
        // 2. find lis (longest increasing sequence) based on second value

        int[] lis = new int[cityPairs.length];

        for (int i = 0; i < cityPairs.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (cityPairs[i][1] > cityPairs[j][1]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int max = lis[0];
        for (int i = 0; i < cityPairs.length; i++) {
            max = Math.max(max, lis[i]);
        }

        return max;
    }

    public static void main(String[] args) {
//        int[][] cityPairs = {{6, 2}, {4, 3}, {2, 6}, {1, 5}}; // {1, 5} {2, 6}
        int[][] cityPairs = {{6, 2}, {4, 3}, {2, 6}, {1, 5}, {1, 3}}; // {1, 3} {1, 5} {2, 6}
        BuildingBridge buildingBridge = new BuildingBridge();
        System.out.println(buildingBridge.bb(cityPairs));
    }
}
