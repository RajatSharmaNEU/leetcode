package GFG.Greedy.Neetcode;

import java.util.Arrays;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        if (Arrays.stream(gas).sum() - Arrays.stream(cost).sum() < 0) {
            return -1;
        }

        int tank = 0;
        int n = gas.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            tank = tank + (gas[i] - cost[i]);

            if (tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
