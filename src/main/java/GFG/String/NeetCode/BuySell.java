package GFG.String.NeetCode;

public class BuySell {
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - buy, maxProfit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
