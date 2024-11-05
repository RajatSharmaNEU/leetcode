package GFG.DP;

public class Practice {
    public static int knapsack(int[] weights, int[] values, int weightLimit, int endIndex) {
        if(endIndex<0 || weightLimit <= 0) {
            return 0;
        }

        if(weights[endIndex] > weightLimit) {
            return knapsack(weights, values, weightLimit, endIndex - 1);
        }

        return Math.max(
                knapsack(weights, values, weightLimit, endIndex - 1),
                values[endIndex] + knapsack(weights, values, weightLimit - weights[endIndex], endIndex - 1)
        );
    }
    public static void main(String[] args) {
        int[] values = new int[]{10, 40, 30, 50};
        int[] weights = new int[]{5, 4, 6, 3};
        int weightLimit = 10;

        System.out.println(knapsack(weights, values, weightLimit, values.length-1));
        System.out.println(knapsack(weights, values, weightLimit, values.length));
    }
}
