package GFG.DP.Neetcode;

public class BuySellCooldownStock {
    Integer[][] profitMemo;

    public int maxProfit(int[] prices) {
        profitMemo = new Integer[prices.length][2];
        dfs(0, 0, prices);
        return profitMemo[0][0];
    }

    public int dfs(int index, int buying, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }

        if (profitMemo[index][buying] != null) {
            return profitMemo[index][buying];
        }

        // case buying
        if (buying == 0) {
            int buy = dfs(index + 1, 1, prices) - prices[index];
            int cooldown = dfs(index + 1, 0, prices);

            profitMemo[index][buying] = Math.max(buy, cooldown);
        }// case selling
        else {
            // +2 as +1 is cooldown
            int sell = dfs(index + 2, 0, prices) + prices[index];
            int cooldown = dfs(index + 1, 1, prices);
            profitMemo[index][buying] = Math.max(sell, cooldown);
        }

        return profitMemo[index][buying];
    }

    public static void main(String[] args) {
        int[] stocks = new int[] {1, 2, 3, 0, 2};
        BuySellCooldownStock buySellCooldownStock = new BuySellCooldownStock();
        System.out.println(buySellCooldownStock.maxProfit(stocks) == 3);
    }
}
