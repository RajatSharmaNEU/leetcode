package GFG.DP.Neetcode;

public class MinCostClimbingStairs {
    public static int minCost(int[] cost) {
        // last two position will always have min value
        // for last 3rd or backward need to find min cost

        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] = Math.min(cost[i] + cost[i+1], cost[i] + cost[i+2]);
        }

        return Math.min(cost[0], cost[1]);
    }
    public static void main(String[] args) {
        int[] stairs = new int[] {10, 20, 30};
        System.out.println(minCost(stairs));
    }
}
