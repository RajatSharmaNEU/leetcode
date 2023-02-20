package solution;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }

            if(prices[i] < buy) {
                buy = prices[i];
            }
        }

        return profit;
    }
}
