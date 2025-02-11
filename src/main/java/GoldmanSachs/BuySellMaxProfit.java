package GoldmanSachs;

public class BuySellMaxProfit {
    public static int buySellApproach(int[] prices) {
        int buy = prices[0], profit = 0;

        for(int sell: prices) {
            if(sell > buy) {
                profit += (sell - buy);
                buy = sell;
            }

            buy = Math.min(buy, sell);
        }

        return profit;
    }

    public static int compareNext(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profit = profit + (prices[i] - prices[i-1]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(buySellApproach(prices));
        System.out.println(compareNext(prices));
    }
}
