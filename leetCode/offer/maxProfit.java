package leetCode.offer;

public class maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
    
}