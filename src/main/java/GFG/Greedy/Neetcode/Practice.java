package GFG.Greedy.Neetcode;

import java.util.Arrays;

public class Practice {
    public static int findStartingGasStation(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() - Arrays.stream(cost).sum() < 0) {
            return -1;
        }

        int totalGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas = totalGas + (gas[i] - cost[i]);

            if(totalGas < 0) {
                totalGas = 0;
                start++;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};

        System.out.println(findStartingGasStation(gas, cost));
    }
}
